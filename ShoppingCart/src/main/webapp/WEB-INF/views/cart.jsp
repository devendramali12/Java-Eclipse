<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="header.jsp" />

<div class="main-container">
    <h1 class="page-title"><i class="fas fa-shopping-cart" style="color:var(--saffron)"></i> My Cart</h1>

    <c:if test="${empty cartItems}">
        <div class="empty-state">
            <div class="empty-icon"><i class="fas fa-cart-plus"></i></div>
            <h3>Your cart is empty</h3>
            <p>Looks like you haven't added anything yet.</p>
            <a href="${pageContext.request.contextPath}/products" class="btn-primary">
                <i class="fas fa-store"></i> Browse Products
            </a>
        </div>
    </c:if>

    <c:if test="${not empty cartItems}">
        <div class="cart-layout">
            <div>
                <div class="cart-items-wrapper">
                    <div class="cart-items-header">
                        <span>Product</span>
                        <span>Quantity</span>
                        <span>Subtotal</span>
                        <span></span>
                    </div>
                    <c:forEach var="item" items="${cartItems}">
                        <div class="cart-item">
                            <div class="cart-item-info">
                                <div class="cart-thumb-wrap">
                                    <c:choose>
                                        <c:when test="${not empty item.imageUrl}">
                                            <img src="${item.imageUrl}" alt="${item.productName}"
                                                 class="cart-thumb"
                                                 onerror="this.style.display='none'">
                                        </c:when>
                                        <c:otherwise>
                                            <div class="cart-thumb-placeholder">🛍️</div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="cart-item-details">
                                    <h3>${item.productName}</h3>
                                    <span class="item-price">&#8377;<fmt:formatNumber value="${item.price}" pattern="#,##0.00"/> each</span>
                                </div>
                            </div>
                            <form action="${pageContext.request.contextPath}/cart" method="post">
                                <input type="hidden" name="action"   value="update">
                                <input type="hidden" name="cartId"   value="${item.cartId}">
                                <input type="number" name="quantity" value="${item.quantity}"
                                       min="0" max="99" class="qty-input" onchange="this.form.submit()">
                            </form>
                            <span class="cart-item-subtotal">&#8377;<fmt:formatNumber value="${item.subtotal}" pattern="#,##0.00"/></span>
                            <a href="${pageContext.request.contextPath}/cart?action=remove&cartId=${item.cartId}"
                               class="btn-remove"
                               onclick="return confirm('Remove ${item.productName} from cart?')">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </div>
                    </c:forEach>
                </div>
                <div style="margin-top:1rem">
                    <a href="${pageContext.request.contextPath}/products" class="btn-secondary">
                        <i class="fas fa-arrow-left"></i> Continue Shopping
                    </a>
                </div>
            </div>

            <div class="order-summary">
                <div class="summary-header"><i class="fas fa-receipt"></i> Order Summary</div>
                <div class="summary-body">
                    <div class="summary-row">
                        <span>Subtotal (${cartItems.size()} item<c:if test="${cartItems.size()>1}">s</c:if>)</span>
                        <span>&#8377;<fmt:formatNumber value="${grandTotal}" pattern="#,##0.00"/></span>
                    </div>
                    <div class="summary-row">
                        <span>Delivery</span>
                        <span class="free-shipping"><i class="fas fa-check"></i> FREE</span>
                    </div>
                    <hr class="summary-divider">
                    <div class="summary-row total-row">
                        <span>Total Payable</span>
                        <span>&#8377;<fmt:formatNumber value="${grandTotal}" pattern="#,##0.00"/></span>
                    </div>
                    <a href="${pageContext.request.contextPath}/checkout" class="btn-primary full-width checkout-btn">
                        <i class="fas fa-lock"></i> Proceed to Checkout
                    </a>
                    <div style="text-align:center;margin-top:.8rem;font-size:.78rem;color:var(--text-soft)">
                        <i class="fas fa-shield-alt"></i> 256-bit SSL Secure Checkout
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>

<jsp:include page="footer.jsp" />