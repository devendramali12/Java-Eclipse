<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />
<div class="main-container">
    <h1 class="page-title"><i class="fas fa-box"></i> My Orders</h1>
    <c:if test="${empty orders}">
        <div class="empty-state">
            <i class="fas fa-box-open fa-4x"></i>
            <h3>No orders yet!</h3>
            <a href="${pageContext.request.contextPath}/products" class="btn-primary">Browse Products</a>
        </div>
    </c:if>
    <c:if test="${not empty orders}">
        <table class="orders-table">
            <thead>
                <tr><th>Order ID</th><th>Date</th><th>Total</th><th>Status</th><th>Address</th></tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td><strong>#${order.orderId}</strong></td>
                        <td><fmt:formatDate value="${order.orderDate}" pattern="dd MMM yyyy"/></td>
                        <td>&#8377;<fmt:formatNumber value="${order.totalAmount}" pattern="#,##0.00"/></td>
                        <td><span class="status-badge status-${order.status.toLowerCase()}">${order.status}</span></td>
                        <td>${order.shippingAddress}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>