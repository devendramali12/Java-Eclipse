<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login — ShopEase</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600;700&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
</head>
<body class="auth-page">
<div class="auth-container">
    <div class="auth-card">
        <div class="auth-logo">Shop<span>Ease</span></div>
        <div class="auth-divider"></div>
        <h2>Welcome Back</h2>
        <p class="auth-subtitle">Sign in to continue shopping</p>

        <c:if test="${not empty error}">
            <div class="alert alert-error"><i class="fas fa-exclamation-circle"></i> ${error}</div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert alert-success"><i class="fas fa-check-circle"></i> ${success}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label><i class="fas fa-user"></i> Username</label>
                <input type="text" name="username" placeholder="Enter your username" required autocomplete="username">
            </div>
            <div class="form-group">
                <label><i class="fas fa-lock"></i> Password</label>
                <input type="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="btn-primary full-width" style="margin-top:.5rem">
                <i class="fas fa-sign-in-alt"></i> Sign In
            </button>
        </form>

        <div class="alert alert-info" style="margin-top:1.2rem; font-size:.8rem;">
            <i class="fas fa-info-circle"></i>
            Demo: <strong>john / john123</strong> &nbsp;|&nbsp; Admin: <strong>admin / admin123</strong>
        </div>

        <p class="auth-footer">New to ShopEase? <a href="${pageContext.request.contextPath}/register">Create an account</a></p>
    </div>
</div>
</body>
</html>