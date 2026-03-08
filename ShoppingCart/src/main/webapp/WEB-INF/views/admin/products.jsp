<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="/WEB-INF/views/header.jsp" />

<c:if test="${empty searchKeyword and empty selectedCategory}">
<div class="hero-banner">
    <h1>Discover <span>Amazing</span> Products</h1>
    <p>Shop across <strong>${categories.size()}</strong> categories</p>
</div>
</c:if>

<div class="main-container">
    <div class="page-header">
        <h1>
            <c:choose>
                <c:when test="${not empty searchKeyword}">
                    <i class="fas fa-search" style="font-size:1.4rem;color:var(--saffron)"></i>
                    Results for &ldquo;<strong>${searchKeyword}</strong>&rdquo;
                </c:when>
                <c:otherwise>All Products</c:otherwise>
            </c:choose>
        </h1>
        <!-- Dynamic Category Pills from DB -->
        <div class="category-filters">
            <a href="${pageContext.request.contextPath}/products"
               class="filter-btn ${empty selectedCategory and empty searchKeyword ? 'active' : ''}">
                &#128717; All
            </a>
            <c:forEach var="cat" items="${categories}">
                <a href="?category=${cat.categoryId}"
                   class="filter-btn ${selectedCategory == cat.categoryId.toString() ? 'active' : ''}">
                    ${cat.emoji} ${cat.categoryName}
                </a>
            </c:forEach>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/products" method="get" class="filter-bar">
        <input type="hidden" name="category" value="${selectedCategory}">
        <input type="hidden" name="search"   value="${searchKeyword}">
        <div class="filter-group">
            <label>Sort by</label>
            <select name="sort" onchange="this.form.submit()">
                <option value="newest"     ${selectedSort == 'newest'     ? 'selected' : ''}>Newest First</option>
                <option value="price_asc"  ${selectedSort == 'price_asc'  ? 'selected' : ''}>Price: Low &#8594; High</option>
                <option value="price_desc" ${selectedSort == 'price_desc' ? 'selected' : ''}>Price: High &#8594; Low</option>
                <option value="name_asc"   ${selectedSort == 'name_asc'   ? 'selected' : ''}>Name A&#8211;Z</option>
            </select>
        </div>
        <div class="filter-group">
            <label>Min Price &#8377;</label>
            <input type="number" name="minPrice" value="${minPrice}" placeholder="0" min="0" style="width:90px">
        </div>
        <div class="filter-group">
            <label>Max Price &#8377;</label>
            <input type="number" name="maxPrice" value="${maxPrice}" placeholder="Any" min="0" style="width:90px">
        </div>
        <button type="submit" class="btn-primary"  style="padding:.42rem 1rem;font-size:.85rem;align-self:flex-end">Apply</button>
        <a href="${pageContext.request.contextPath}/products" class="btn-secondary" style="padding:.42rem 1rem;font-size:.85rem;align-self:flex-end">Reset</a>
    </form>

    <c:if test="${not empty products}">
        <div class="stats-bar">
            <span>Showing <strong>${products.size()}</strong> of <strong>${totalProducts}</strong> products</span>
        </div>
    </c:if>

    <c:if test="${empty products}">
        <div class="empty-state">
            <div class="empty-icon"><i class="fas fa-search"></i></div>
            <h3>No products found</h3>
            <p>Try different filters or browse all products.</p>
            <a href="${pageContext.request.contextPath}/products" class="btn-primary">View All Products</a>
        </div>
    </c:if>

    <div class="products-grid">
        <c:forEach var="product" items="${products}">
            <div class="product-card">
                <a href="${pageContext.request.contextPath}/products?action=detail&id=${product.productId}"
                   class="product-image-link">
                    <div class="product-image-wrap">
                        <c:choose>
                            <c:when test="${not empty product.imageUrl}">
                                <img src="${product.imageUrl}" alt="${product.productName}"
                                     class="product-img" loading="lazy"
                                     onerror="this.style.display='none';this.nextElementSibling.style.display='flex'">
                                <div class="product-img-fallback" style="display:none">
                                    ${not empty product.categoryEmoji ? product.categoryEmoji : '&#128717;'}
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="product-img-fallback">
                                    ${not empty product.categoryEmoji ? product.categoryEmoji : '&#128717;'}
                                </div>
                            </c:otherwise>
                        </c:choose>
                        <span class="category-badge">${product.categoryName}</span>
                    </div>
                </a>
                <div class="product-info">
                    <h3 class="product-name">${product.productName}</h3>
                    <p class="product-desc">${product.description}</p>
                    <div class="product-footer">
                        <span class="product-price">&#8377;<fmt:formatNumber value="${product.price}" pattern="#,##0.00"/></span>
                        <c:choose>
                            <c:when test="${product.stockQuantity > 0}">
                                <span class="stock in-stock"><i class="fas fa-circle" style="font-size:.45rem"></i> In Stock</span>
                            </c:when>
                            <c:otherwise>
                                <span class="stock out-of-stock"><i class="fas fa-circle" style="font-size:.45rem"></i> Out of Stock</span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="product-actions">
                        <a href="${pageContext.request.contextPath}/products?action=detail&id=${product.productId}"
                           class="btn-secondary" style="flex:0 0 auto;padding:.45rem .85rem">
                            <i class="fas fa-eye"></i>
                        </a>
                        <c:choose>
                            <c:when test="${not empty sessionScope.loggedUser and product.stockQuantity > 0}">
                                <form action="${pageContext.request.contextPath}/cart" method="post" style="flex:1">
                                    <input type="hidden" name="action"    value="add">
                                    <input type="hidden" name="productId" value="${product.productId}">
                                    <input type="hidden" name="quantity"  value="1">
                                    <button type="submit" class="btn-primary full-width">
                                        <i class="fas fa-cart-plus"></i> Add to Cart
                                    </button>
                                </form>
                            </c:when>
                            <c:when test="${empty sessionScope.loggedUser}">
                                <a href="${pageContext.request.contextPath}/login" class="btn-primary full-width">
                                    <i class="fas fa-sign-in-alt"></i> Login to Buy
                                </a>
                            </c:when>
                            <c:otherwise>
                                <button class="btn-secondary full-width" disabled>Out of Stock</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <c:if test="${totalPages > 1}">
        <div class="pagination">
            <c:if test="${currentPage > 1}">
                <a href="?page=${currentPage-1}&category=${selectedCategory}&search=${searchKeyword}&sort=${selectedSort}&minPrice=${minPrice}&maxPrice=${maxPrice}"
                   class="page-btn"><i class="fas fa-chevron-left"></i></a>
            </c:if>
            <c:forEach begin="1" end="${totalPages}" var="p">
                <a href="?page=${p}&category=${selectedCategory}&search=${searchKeyword}&sort=${selectedSort}&minPrice=${minPrice}&maxPrice=${maxPrice}"
                   class="page-btn ${p == currentPage ? 'active' : ''}">${p}</a>
            </c:forEach>
            <c:if test="${currentPage < totalPages}">
                <a href="?page=${currentPage+1}&category=${selectedCategory}&search=${searchKeyword}&sort=${selectedSort}&minPrice=${minPrice}&maxPrice=${maxPrice}"
                   class="page-btn"><i class="fas fa-chevron-right"></i></a>
            </c:if>
        </div>
    </c:if>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp" />