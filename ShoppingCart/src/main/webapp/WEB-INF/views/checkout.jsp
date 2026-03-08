<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="header.jsp" />

<div class="main-container">
    <h1 class="page-title"><i class="fas fa-lock" style="color:var(--saffron)"></i> Secure Checkout</h1>
    <div class="checkout-layout">
        <div>
            <div class="checkout-card" style="margin-bottom:1.3rem">
                <div class="checkout-card-header"><i class="fas fa-box-open"></i> Order Items (${cartItems.size()})</div>
                <div class="checkout-card-body">
                    <c:forEach var="item" items="${cartItems}">
                        <div class="checkout-item">
                            <span class="checkout-item-name">${item.productName}</span>
                            <span class="checkout-item-qty">x${item.quantity}</span>
                            <span class="checkout-item-price">&#8377;<fmt:formatNumber value="${item.subtotal}" pattern="#,##0.00"/></span>
                        </div>
                    </c:forEach>
                    <div class="checkout-total">
                        <span>Grand Total</span>
                        <span>&#8377;<fmt:formatNumber value="${grandTotal}" pattern="#,##0.00"/></span>
                    </div>
                </div>
            </div>
            <div style="display:flex;gap:1rem;flex-wrap:wrap">
                <div class="trust-badge"><i class="fas fa-shield-alt" style="color:var(--success)"></i> Secure Payment</div>
                <div class="trust-badge"><i class="fas fa-undo"        style="color:var(--saffron)"></i> Easy Returns</div>
                <div class="trust-badge"><i class="fas fa-truck"       style="color:var(--navy)"></i>    Free Delivery</div>
            </div>
        </div>
        <div class="checkout-card">
            <div class="checkout-card-header"><i class="fas fa-map-marker-alt"></i> Shipping Details</div>
            <div class="checkout-card-body">
                <form action="${pageContext.request.contextPath}/checkout" method="post">
                    <div class="form-group">
                        <label><i class="fas fa-user"></i> Full Name</label>
                        <input type="text" value="${user.fullName}" readonly class="readonly-input">
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-phone"></i> Phone</label>
                        <input type="text" value="${user.phone}" readonly class="readonly-input">
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-map-marker-alt"></i> Shipping Address *</label>
                        <textarea name="shippingAddress" rows="4" required
                                  placeholder="House No, Street, Area, City, State, PIN">${user.address}</textarea>
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-credit-card"></i> Payment Method</label>
                        <select style="width:100%;padding:.65rem 1rem;border:1.5px solid var(--border);border-radius:var(--radius-sm);font-family:'DM Sans',sans-serif;background:var(--ivory)">
                            <option>💵 Cash on Delivery (COD)</option>
                            <option>📱 UPI Payment</option>
                            <option>🏦 Net Banking</option>
                        </select>
                    </div>
                    <button type="submit" class="btn-primary full-width" style="padding:.85rem;font-size:.95rem">
                        <i class="fas fa-check-circle"></i>
                        Place Order — &#8377;<fmt:formatNumber value="${grandTotal}" pattern="#,##0.00"/>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />