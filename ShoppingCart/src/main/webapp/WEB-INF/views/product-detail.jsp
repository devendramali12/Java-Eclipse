<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="header.jsp" />

<div class="main-container">
    <div class="breadcrumb">
        <a href="${pageContext.request.contextPath}/products">Products</a>
        <i class="fas fa-chevron-right"></i>
        <span>${product.categoryName}</span>
        <i class="fas fa-chevron-right"></i>
        <span>${product.productName}</span>
    </div>

    <div class="detail-layout">
        <!-- Product Image -->
        <div class="detail-image-wrap">
            <c:choose>
                <c:when test="${not empty product.imageUrl}">
                    <img src="${product.imageUrl}" alt="${product.productName}" class="detail-img"
                         onerror="this.style.display='none'; document.getElementById('fallback').style.display='flex'">
                    <div id="fallback" class="detail-img-fallback" style="display:none">🛍️</div>
                </c:when>
                <c:otherwise>
                    <div class="detail-img-fallback">🛍️</div>
                </c:otherwise>
            </c:choose>
        </div>

        <!-- Product Info -->
        <div class="detail-info">
            <span class="detail-category-badge">${product.categoryName}</span>
            <h1 class="detail-title">${product.productName}</h1>
            <p class="detail-desc">${product.description}</p>

            <div class="detail-price">
                &#8377;<fmt:formatNumber value="${product.price}" pattern="#,##0.00"/>
            </div>

            <div class="detail-stock">
                <c:choose>
                    <c:when test="${product.stockQuantity > 10}">
                        <span class="stock in-stock"><i class="fas fa-check-circle"></i> In Stock (${product.stockQuantity} available)</span>
                    </c:when>
                    <c:when test="${product.stockQuantity > 0}">
                        <span class="stock" style="color:#d69e2e"><i class="fas fa-exclamation-circle"></i> Only ${product.stockQuantity} left!</span>
                    </c:when>
                    <c:otherwise>
                        <span class="stock out-of-stock"><i class="fas fa-times-circle"></i> Out of Stock</span>
                    </c:otherwise>
                </c:choose>
            </div>

            <c:if test="${product.stockQuantity > 0 and not empty sessionScope.loggedUser}">
                <form action="${pageContext.request.contextPath}/cart" method="post" class="detail-add-form">
                    <input type="hidden" name="action"    value="add">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <div class="qty-selector">
                        <label>Quantity:</label>
                        <div class="qty-controls">
                            <button type="button" onclick="changeQty(-1)">−</button>
                            <input type="number" name="quantity" id="qtyInput" value="1" min="1" max="${product.stockQuantity}" readonly>
                            <button type="button" onclick="changeQty(1)">+</button>
                        </div>
                    </div>
                    <div class="detail-actions">
                        <button type="submit" class="btn-primary" style="padding:.8rem 2rem;font-size:1rem">
                            <i class="fas fa-cart-plus"></i> Add to Cart
                        </button>
                        <a href="${pageContext.request.contextPath}/products" class="btn-secondary" style="padding:.8rem 1.5rem">
                            <i class="fas fa-arrow-left"></i> Back
                        </a>
                    </div>
                </form>
            </c:if>
            <c:if test="${empty sessionScope.loggedUser}">
                <a href="${pageContext.request.contextPath}/login" class="btn-primary" style="padding:.8rem 2rem;font-size:1rem;margin-top:1rem;display:inline-flex">
                    <i class="fas fa-sign-in-alt"></i> Login to Buy
                </a>
            </c:if>

            <div class="detail-features">
                <div class="feature-item"><i class="fas fa-truck"></i> Free Delivery</div>
                <div class="feature-item"><i class="fas fa-undo"></i> Easy Returns</div>
                <div class="feature-item"><i class="fas fa-shield-alt"></i> Secure Payment</div>
            </div>
        </div>
    </div>
</div>

<script>
function changeQty(delta) {
    const input = document.getElementById('qtyInput');
    const max   = parseInt(input.max);
    let val     = parseInt(input.value) + delta;
    if (val < 1)   val = 1;
    if (val > max) val = max;
    input.value = val;
}
</script>

<jsp:include page="footer.jsp" />