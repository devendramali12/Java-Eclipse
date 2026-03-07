<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" />
<div class="main-container">
    <div class="success-container">
        <div class="success-icon">&#10004;</div>
        <h1>Order Placed Successfully!</h1>
        <p>Your Order ID: <strong>#${orderId}</strong></p>
        <p>Thank you for shopping with ShopEase!</p>
        <div class="success-actions">
            <a href="${pageContext.request.contextPath}/orders" class="btn-primary">View My Orders</a>
            <a href="${pageContext.request.contextPath}/products" class="btn-secondary">Continue Shopping</a>
        </div>
    </div>
</div>
</body>
</html>