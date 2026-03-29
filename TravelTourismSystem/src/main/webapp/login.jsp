<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- login.jsp | Location: src/main/webapp/login.jsp -->
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Login &mdash; WanderLux</title><link rel="stylesheet" href="css/style.css"></head>
<body>
<nav class="navbar"><div class="navbar-brand">&#10022; Wander<span>Lux</span></div>
<div class="navbar-links"><a href="index.html">Home</a><a href="packages.jsp">Packages</a><a href="register.jsp" class="btn-nav">Register</a></div></nav>
<div class="form-page">
<div class="form-card">
    <div class="form-logo">&#10022; WanderLux</div>
    <h2 class="form-title">Welcome Back</h2>
    <p class="form-subtitle">Sign in to access your travel bookings</p>
    <% String error=(String)request.getAttribute("error"); String success=(String)request.getAttribute("success"); %>
    <% if(error!=null&&!error.isEmpty()){ %><div class="alert alert-error"><span>&#9888;</span> <%=error%></div><% } %>
    <% if(success!=null&&!success.isEmpty()){ %><div class="alert alert-success"><span>&#10003;</span> <%=success%></div><% } %>
    <form action="LoginServlet" method="post" onsubmit="return validateLoginForm()">
        <div class="form-group"><label for="email">Email Address</label><input type="email" id="email" name="email" placeholder="you@example.com" required></div>
        <div class="form-group"><label for="password">Password</label><input type="password" id="password" name="password" placeholder="Enter your password" required></div>
        <button type="submit" class="btn btn-primary btn-full">Sign In &rarr;</button>
    </form>
    <div class="form-footer">Don't have an account? <a href="register.jsp">Create one free</a><br>
    <a href="admin-login.jsp" style="color:var(--gray-400);margin-top:8px;display:block">Admin Login</a></div>
</div></div>
<script src="js/script.js"></script></body></html>