<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />
<div class="main-container">
    <div class="page-header">
        <h1>
            <c:choose>
                <c:when test="${not empty searchKeyword}">Results for: "<strong>${searchKeyword}</strong>"</c:when>
                <c:otherwise>All Products</c:otherwise>
            </c:choose>
        </h1>
        <div class="category-filters">
            <a href="${pageContext.request.contextPath}/products" class="filter-btn ${empty selectedCategory ? 'active' : ''}">All</a>
            <a href="?category=1" class="filter-btn ${selectedCategory == '1' ? 'active' : ''}">Electronics</a>
            <a href="?category=2" class="filter-btn ${selectedCategory == '2' ? 'active' : ''}">Clothing</a>
            <a href="?category=3" class="filter-btn ${selectedCategory == '3' ? 'active' : ''}">Books</a>
            <a href="?category=4" class="filter-btn ${selectedCategory == '4' ? 'active' : ''}">Home & Kitchen</a>
        </div>
    </div>
    <c:if test="${empty products}">
        <div class="empty-state"><i class="fas fa-search fa-3x"></i><h3>No products found</h3></div>
    </c:if>
    <div class="products-grid">
        <c:forEach var="product" items="${products}">
            <div class="product-card">
                <div class="product-image">
                    <span class="category-badge">${product.categoryName}</span>
                </div>
                <div class="product-info">
                    <h3 class="product-name">${product.productName}</h3>
                    <p class="product-desc">${product.description}</p>
                    <div class="product-footer">
                        <span class="product-price">&#8377;<fmt:formatNumber value="${product.price}" pattern="#,##0.00"/></span>
                        <c:choose>
                            <c:when test="${product.stockQuantity > 0}"><span class="stock in-stock">In Stock</span></c:when>
                            <c:otherwise><span class="stock out-of-stock">Out of Stock</span></c:otherwise>
                        </c:choose>
                    </div>
                    <div class="product-actions">
                        <c:if test="${product.stockQuantity > 0 and not empty sessionScope.loggedUser}">
                            <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline">
                                <input type="hidden" name="action" value="add">
                                <input type="hidden" name="productId" value="${product.productId}">
                                <input type="hidden" name="quantity" value="1">
                                <button type="submit" class="btn-primary"><i class="fas fa-cart-plus"></i> Add to Cart</button>
                            </form>
                        </c:if>
                        <c:if test="${empty sessionScope.loggedUser}">
                            <a href="${pageContext.request.contextPath}/login" class="btn-primary">Login to Buy</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>