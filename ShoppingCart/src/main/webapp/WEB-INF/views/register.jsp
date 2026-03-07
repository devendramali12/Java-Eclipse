<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"><title>Register - ShopEase</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body class="auth-page">
<div class="auth-container">
    <div class="auth-card wide-card">
        <div class="auth-logo">🛒 ShopEase</div>
        <h2>Create Account</h2>
        <c:if test="${not empty error}">
            <div class="alert alert-error">${error}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-row">
                <div class="form-group">
                    <label>Full Name</label>
                    <input type="text" name="fullName" placeholder="John Doe" required>
                </div>
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="username" placeholder="Choose username" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" placeholder="your@email.com" required>
                </div>
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" name="phone" placeholder="9876543210">
                </div>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Create password" required minlength="6">
            </div>
            <div class="form-group">
                <label>Address</label>
                <textarea name="address" placeholder="Your shipping address" rows="2"></textarea>
            </div>
            <button type="submit" class="btn-primary full-width">Create Account</button>
        </form>
        <p class="auth-footer">Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a></p>
    </div>
</div>
</body>
</html>