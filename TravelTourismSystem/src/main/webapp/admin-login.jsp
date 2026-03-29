<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- admin-login.jsp | Location: src/main/webapp/admin-login.jsp -->
<% if(session.getAttribute("admin")!=null){response.sendRedirect("admin-dashboard.jsp");return;} %>
<% String error=(String)request.getAttribute("error"); %>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Admin Login &mdash; WanderLux</title><link rel="stylesheet" href="css/style.css"></head>
<body>
<div class="form-page" style="background:linear-gradient(135deg,#060d17 0%,#0d1e35 100%)">
<div class="form-card">
    <div class="form-logo" style="font-size:1.1rem;letter-spacing:.1em;text-transform:uppercase">&#9881; Admin Portal</div>
    <h2 class="form-title">Admin Login</h2>
    <p class="form-subtitle">Restricted area &mdash; authorised personnel only</p>
    <% if(error!=null&&!error.isEmpty()){ %><div class="alert alert-error"><span>&#9888;</span> <%=error%></div><% } %>
    <form action="AdminLogin" method="post">
        <div class="form-group"><label for="username">Username</label><input type="text" id="username" name="username" placeholder="admin" required></div>
        <div class="form-group"><label for="password">Password</label><input type="password" id="password" name="password" placeholder="&bull;&bull;&bull;&bull;&bull;&bull;&bull;&bull;" required></div>
        <button type="submit" class="btn btn-primary btn-full">Access Dashboard &rarr;</button>
    </form>
    <div class="form-footer"><a href="login.jsp">&larr; User Login</a></div>
</div></div>
<script src="js/script.js"></script></body></html>