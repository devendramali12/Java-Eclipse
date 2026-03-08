<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="header.jsp" />

<div class="main-container">
    <div class="breadcrumb">
        <a href="${pageContext.request.contextPath}/orders">My Orders</a>
        <i class="fas fa-chevron-right"></i>
        <span>Order #${order.orderId}</span>
    </div>

    <div class="invoice-wrap">
        <!-- Invoice Header -->
        <div class="invoice-header">
            <div>
                <div class="invoice-logo">Shop<span>Ease</span></div>
                <p style="color:rgba(255,255,255,.6);font-size:.85rem">Your trusted online store</p>
            </div>
            <div style="text-align:right">
                <div style="font-size:1.4rem;font-weight:700">ORDER INVOICE</div>
                <div style="color:rgba(255,255,255,.7);font-size:.9rem">
                    #${order.orderId} &nbsp;|&nbsp;
                    <fmt:formatDate value="${order.orderDate}" pattern="dd MMM yyyy, hh:mm a"/>
                </div>
                <div style="margin-top:.5rem">
                    <span class="status-badge status-${order.status.toLowerCase()}">${order.status}</span>
                </div>
            </div>
        </div>

        <div class="invoice-body">
            <!-- Shipping Address -->
            <div class="invoice-section">
                <h3><i class="fas fa-map-marker-alt"></i> Delivered To</h3>
                <p>${order.shippingAddress}</p>
            </div>

            <!-- Order Items Table -->
            <div class="invoice-section">
                <h3><i class="fas fa-box-open"></i> Items Ordered</h3>
                <table class="invoice-table">
                    <thead>
                        <tr><th>Product</th><th>Unit Price</th><th>Qty</th><th>Subtotal</th></tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${orderItems}">
                            <tr>
                                <td>
                                    <div style="display:flex;align-items:center;gap:.7rem">
                                        <c:if test="${not empty item.imageUrl}">
                                            <img src="${item.imageUrl}" alt="${item.productName}"
                                                 style="width:44px;height:44px;object-fit:cover;border-radius:8px"
                                                 onerror="this.style.display='none'">
                                        </c:if>
                                        <span style="font-weight:500">${item.productName}</span>
                                    </div>
                                </td>
                                <td>&#8377;<fmt:formatNumber value="${item.price}" pattern="#,##0.00"/></td>
                                <td>${item.quantity}</td>
                                <td><strong>&#8377;<fmt:formatNumber value="${item.subtotal}" pattern="#,##0.00"/></strong></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="3" style="text-align:right;font-weight:700;padding:.8rem 1rem">Grand Total</td>
                            <td style="font-size:1.1rem;font-weight:700;color:var(--navy)">
                                &#8377;<fmt:formatNumber value="${order.totalAmount}" pattern="#,##0.00"/>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>

            <div style="text-align:center;margin-top:1.5rem">
                <a href="${pageContext.request.contextPath}/orders"   class="btn-primary"><i class="fas fa-arrow-left"></i> Back to Orders</a>
                <a href="${pageContext.request.contextPath}/products" class="btn-secondary" style="margin-left:.8rem"><i class="fas fa-store"></i> Continue Shopping</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />