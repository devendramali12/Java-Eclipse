<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />
<div class="main-container">
    <h1 class="page-title"><i class="fas fa-credit-card"></i> Checkout</h1>
    <div class="checkout-layout">
        <div class="checkout-items">
            <h2>Order Items</h2>
            <c:forEach var="item" items="${cartItems}">
                <div class="checkout-item">
                    <span>${item.productName}</span>
                    <span>x${item.quantity}</span>
                    <span>&#8377;<fmt:formatNumber value="${item.subtotal}" pattern="#,##0.00"/></span>
                </div>
            </c:forEach>
            <div class="checkout-total">
                <strong>Total: &#8377;<fmt:formatNumber value="${grandTotal}" pattern="#,##0.00"/></strong>
            </div>
        </div>
        <div class="checkout-form-section">
            <h2>Shipping Details</h2>
            <form action="${pageContext.request.contextPath}/checkout" method="post">
                <div class="form-group">
                    <label>Full Name</label>
                    <input type="text" value="${user.fullName}" readonly class="readonly-input">
                </div>
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" value="${user.phone}" readonly class="readonly-input">
                </div>
                <div class="form-group">
                    <label>Shipping Address *</label>
                    <textarea name="shippingAddress" rows="4" required placeholder="Enter complete address...">${user.address}</textarea>
                </div>
                <button type="submit" class="btn-primary full-width">
                    Place Order (&#8377;<fmt:formatNumber value="${grandTotal}" pattern="#,##0.00"/>)
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>