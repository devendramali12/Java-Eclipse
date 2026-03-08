<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" />
<div class="main-container success-page">
    <div class="success-container">
        <div class="success-icon">&#10003;</div>
        <h1>Order Confirmed!</h1>
        <p>Your order has been placed successfully.</p>
        <div class="order-id-badge">Order #${orderId}</div>
        <p style="font-size:.85rem;color:var(--text-soft)">We'll process your order shortly. Thank you for shopping with ShopEase!</p>
        <div class="success-actions">
            <a href="${pageContext.request.contextPath}/orders"   class="btn-primary"><i class="fas fa-box-open"></i> Track My Orders</a>
            <a href="${pageContext.request.contextPath}/products" class="btn-secondary"><i class="fas fa-store"></i> Continue Shopping</a>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />