<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="header.jsp" />
<div class="main-container">
    <h1 class="page-title"><i class="fas fa-box-open" style="color:var(--saffron)"></i> My Orders</h1>
    <c:if test="${empty orders}">
        <div class="empty-state">
            <div class="empty-icon"><i class="fas fa-box-open"></i></div>
            <h3>No orders yet</h3>
            <p>You haven't placed any orders yet.</p>
            <a href="${pageContext.request.contextPath}/products" class="btn-primary"><i class="fas fa-store"></i> Browse Products</a>
        </div>
    </c:if>
    <c:if test="${not empty orders}">
        <div class="stats-bar"><span>Total Orders: <strong>${orders.size()}</strong></span></div>
        <table class="orders-table">
            <thead>
                <tr><th>Order ID</th><th>Date</th><th>Total</th><th>Status</th><th>Action</th></tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td><strong style="color:var(--saffron)">#${order.orderId}</strong></td>
                        <td>
                            <fmt:formatDate value="${order.orderDate}" pattern="dd MMM yyyy"/><br>
                            <span style="color:var(--text-soft);font-size:.78rem"><fmt:formatDate value="${order.orderDate}" pattern="hh:mm a"/></span>
                        </td>
                        <td><strong>&#8377;<fmt:formatNumber value="${order.totalAmount}" pattern="#,##0.00"/></strong></td>
                        <td><span class="status-badge status-${order.status.toLowerCase()}">${order.status}</span></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/order-detail?id=${order.orderId}" class="btn-secondary" style="padding:.3rem .8rem;font-size:.8rem">
                                <i class="fas fa-receipt"></i> View Invoice
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<jsp:include page="footer.jsp" />