<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- register.jsp | Location: src/main/webapp/register.jsp -->
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Register &mdash; WanderLux</title><link rel="stylesheet" href="css/style.css"></head>
<body>
<nav class="navbar"><div class="navbar-brand">&#10022; Wander<span>Lux</span></div>
<div class="navbar-links"><a href="index.html">Home</a><a href="packages.jsp">Packages</a><a href="login.jsp" class="btn-nav">Login</a></div></nav>
<div class="form-page">
<div class="form-card">
    <div class="form-logo">&#10022; WanderLux</div>
    <h2 class="form-title">Start Your Journey</h2>
    <p class="form-subtitle">Create your account and unlock exclusive travel deals</p>
    <% String error=(String)request.getAttribute("error"); %>
    <% if(error!=null&&!error.isEmpty()){ %><div class="alert alert-error"><span>&#9888;</span> <%=error%></div><% } %>
    <form action="RegisterServlet" method="post" onsubmit="return validateRegisterForm()">
        <div class="form-group"><label for="name">Full Name</label><input type="text" id="name" name="name" placeholder="Your full name" required></div>
        <div class="form-group"><label for="email">Email Address</label><input type="email" id="email" name="email" placeholder="you@example.com" required></div>
        <div class="form-row">
            <div class="form-group"><label for="password">Password</label><input type="password" id="password" name="password" placeholder="Min. 6 characters" required></div>
            <div class="form-group"><label for="phone">Phone Number</label><input type="tel" id="phone" name="phone" placeholder="+91 98765 43210"></div>
        </div>
        <button type="submit" class="btn btn-primary btn-full">Create Account &rarr;</button>
    </form>
    <div class="form-footer">Already have an account? <a href="login.jsp">Sign in</a></div>
</div></div>
<script src="js/script.js"></script></body></html>