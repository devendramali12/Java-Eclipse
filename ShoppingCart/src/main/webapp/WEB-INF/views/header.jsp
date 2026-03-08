<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShopEase</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600;700&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
</head>
<body>
<nav class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/products" class="nav-logo">Shop<span>Ease</span></a>
        <form action="${pageContext.request.contextPath}/products" method="get" class="search-form">
            <input type="text" name="search" placeholder="Search products..." value="${searchKeyword}">
            <button type="submit"><i class="fas fa-search"></i></button>
        </form>
        <div class="nav-links">
            <c:choose>
                <c:when test="${not empty sessionScope.loggedUser}">
                    <a href="${pageContext.request.contextPath}/cart" class="nav-link cart-link">
                        <i class="fas fa-shopping-cart"></i> Cart
                        <c:if test="${sessionScope.cartCount > 0}">
                            <span class="cart-badge">${sessionScope.cartCount}</span>
                        </c:if>
                    </a>
                    <a href="${pageContext.request.contextPath}/orders"  class="nav-link"><i class="fas fa-box-open"></i> Orders</a>
                    <a href="${pageContext.request.contextPath}/profile" class="nav-link"><i class="fas fa-user"></i> ${sessionScope.loggedUser.fullName}</a>
                    <c:if test="${sessionScope.loggedUser.admin}">
                        <a href="${pageContext.request.contextPath}/admin/dashboard" class="nav-link btn-admin">
                            <i class="fas fa-shield-alt"></i> Admin
                        </a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/logout" class="nav-link btn-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login"    class="nav-link">Login</a>
                    <a href="${pageContext.request.contextPath}/register" class="nav-link btn-register">Register</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>