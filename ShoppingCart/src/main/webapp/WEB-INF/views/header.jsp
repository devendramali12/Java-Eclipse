<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ShopEase</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<nav class="navbar">
    <div class="nav-container">
        <a href="${pageContext.request.contextPath}/products" class="nav-logo">🛒 ShopEase</a>
        <form action="${pageContext.request.contextPath}/products" method="get" class="search-form">
            <input type="text" name="search" placeholder="Search products..." value="${searchKeyword}">
            <button type="submit"><i class="fas fa-search"></i></button>
        </form>
        <div class="nav-links">
            <c:choose>
                <c:when test="${not empty sessionScope.loggedUser}">
                    <a href="${pageContext.request.contextPath}/cart" class="nav-link"><i class="fas fa-shopping-cart"></i> Cart</a>
                    <a href="${pageContext.request.contextPath}/orders" class="nav-link"><i class="fas fa-box"></i> Orders</a>
                    <a href="${pageContext.request.contextPath}/logout" class="nav-link btn-logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a>
                    <a href="${pageContext.request.contextPath}/register" class="nav-link btn-register">Register</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>