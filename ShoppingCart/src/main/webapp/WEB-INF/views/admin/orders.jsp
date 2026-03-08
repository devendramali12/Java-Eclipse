<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="../header.jsp" />
<div class="main-container">
    <h1 class="page-title"><i class="fas fa-shopping-bag" style="color:var(--saffron)"></i> All Orders</h1>
    <c:if test="${param.msg == 'updated'}"><div class="alert alert-success"><i class="fas fa-check-circle"></i> Order status updated!</div></c:if>
    <table class="orders-table">
        <thead>
            <tr><th>Order ID</th><th>Customer</th><th>Date</th><th>Total</th><th>Status</th><th>Actions</th></tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><strong style="color:var(--saffron)">#${order.orderId}</strong></td>
                    <td>${order.customerName}</td>
                    <td><fmt:formatDate value="${order.orderDate}" pattern="dd MMM yyyy"/></td>
                    <td><strong>&#8377;<fmt:formatNumber value="${order.totalAmount}" pattern="#,##0.00"/></strong></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/admin/orders/status" method="post" style="display:inline">
                            <input type="hidden" name="orderId" value="${order.orderId}">
                            <select name="status" onchange="this.form.submit()"
                                    style="padding:.3rem .6rem;border:1.5px solid var(--border);border-radius:6px;font-family:'DM Sans',sans-serif;font-size:.82rem;background:var(--ivory)">
                                <option value="PENDING"   ${order.status=='PENDING'   ? 'selected':''}>PENDING</option>
                                <option value="CONFIRMED" ${order.status=='CONFIRMED' ? 'selected':''}>CONFIRMED</option>
                                <option value="SHIPPED"   ${order.status=='SHIPPED'   ? 'selected':''}>SHIPPED</option>
                                <option value="DELIVERED" ${order.status=='DELIVERED' ? 'selected':''}>DELIVERED</option>
                                <option value="CANCELLED" ${order.status=='CANCELLED' ? 'selected':''}>CANCELLED</option>
                            </select>
                        </form>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/orders/detail?id=${order.orderId}" class="btn-secondary" style="padding:.3rem .7rem;font-size:.8rem"><i class="fas fa-receipt"></i> Details</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../footer.jsp" />