<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />
<div class="main-container">
    <h1 class="page-title"><i class="fas fa-shopping-cart"></i> My Cart</h1>
    <c:if test="${empty cartItems}">
        <div class="empty-state">
            <i class="fas fa-cart-plus fa-4x"></i>
            <h3>Your cart is empty!</h3>
            <a href="${pageContext.request.contextPath}/products" class="btn-primary">Browse Products</a>
        </div>
    </c:if>
    <c:if test="${not empty cartItems}">
        <div class="cart-layout">
            <div class="cart-items">
                <c:forEach var="item" items="${cartItems}">
                    <div class="cart-item">
                        <div class="cart-item-details">
                            <h3>${item.productName}</h3>
                            <p class="item-price">&#8377;<fmt:formatNumber value="${item.price}" pattern="#,##0.00"/> each</p>
                        </div>
                        <div class="cart-item-qty">
                            <form action="${pageContext.request.contextPath}/cart" method="post">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="cartId" value="${item.cartId}">
                                <input type="number" name="quantity" value="${item.quantity}" min="0" max="99" onchange="this.form.submit()" class="qty-input">
                            </form>
                        </div>
                        <div class="cart-item-subtotal">&#8377;<fmt:formatNumber value="${item.subtotal}" pattern="#,##0.00"/></div>
                        <a href="${pageContext.request.contextPath}/cart?action=remove&cartId=${item.cartId}" class="btn-remove"><i class="fas fa-trash"></i></a>
                    </div>
                </c:forEach>
            </div>
            <div class="order-summary">
                <h2>Order Summary</h2>
                <div class="summary-row"><span>Shipping</span><span class="free-shipping">FREE</span></div>
                <div class="summary-divider"></div>
                <div class="summary-row total-row"><span>Grand Total</span><span>&#8377;<fmt:formatNumber value="${grandTotal}" pattern="#,##0.00"/></span></div>
                <a href="${pageContext.request.contextPath}/checkout" class="btn-primary full-width checkout-btn">Proceed to Checkout</a>
                <a href="${pageContext.request.contextPath}/products" class="btn-secondary full-width">Continue Shopping</a>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>