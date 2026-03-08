<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="../header.jsp" />
<div class="main-container">
    <h1 class="page-title"><i class="fas fa-shield-alt" style="color:var(--saffron)"></i> Admin Dashboard</h1>
    <div class="admin-stats">
        <div class="admin-stat-card">
            <div class="stat-icon" style="background:linear-gradient(135deg,#1a2744,#253460)"><i class="fas fa-box"></i></div>
            <div class="stat-info"><div class="stat-number">${totalProducts}</div><div class="stat-label">Total Products</div></div>
            <a href="${pageContext.request.contextPath}/admin/products" class="stat-link">Manage →</a>
        </div>
        <div class="admin-stat-card">
            <div class="stat-icon" style="background:linear-gradient(135deg,#e8872a,#f5a14e)"><i class="fas fa-shopping-bag"></i></div>
            <div class="stat-info"><div class="stat-number">${totalOrders}</div><div class="stat-label">Total Orders</div></div>
            <a href="${pageContext.request.contextPath}/admin/orders" class="stat-link">Manage →</a>
        </div>
        <div class="admin-stat-card">
            <div class="stat-icon" style="background:linear-gradient(135deg,#2d7a4f,#38a169)"><i class="fas fa-users"></i></div>
            <div class="stat-info"><div class="stat-number">${totalUsers}</div><div class="stat-label">Registered Users</div></div>
            <a href="${pageContext.request.contextPath}/admin/dashboard" class="stat-link">View →</a>
        </div>
    </div>
    <div class="admin-quick-links">
        <a href="${pageContext.request.contextPath}/admin/products/add" class="btn-primary"><i class="fas fa-plus"></i> Add New Product</a>
        <a href="${pageContext.request.contextPath}/admin/orders"       class="btn-secondary"><i class="fas fa-list"></i> View All Orders</a>
        <a href="${pageContext.request.contextPath}/products"           class="btn-secondary"><i class="fas fa-store"></i> View Store</a>
    </div>
</div>
<jsp:include page="../footer.jsp" />