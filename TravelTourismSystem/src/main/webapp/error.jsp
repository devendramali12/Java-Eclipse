<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%-- error.jsp — Generic error page | Location: src/main/webapp/error.jsp --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Error &mdash; WanderLux</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="navbar">
    <div class="navbar-brand">&#10022; Wander<span>Lux</span></div>
    <div class="navbar-links"><a href="index.html">Home</a><a href="packages.jsp">Packages</a></div>
</nav>
<div style="min-height:100vh;display:flex;align-items:center;justify-content:center;background:var(--white);padding:100px 5% 60px;text-align:center">
    <div>
        <div style="font-size:5rem;margin-bottom:24px">&#9888;&#65039;</div>
        <h1 style="font-family:var(--font-display);color:var(--navy);margin-bottom:16px">Something went wrong</h1>
        <p style="color:var(--gray-600);font-size:1.05rem;margin-bottom:32px;max-width:480px;margin-left:auto;margin-right:auto">
            We encountered an unexpected error. Please try again or return to the homepage.
        </p>
        <% if (exception != null) { %>
        <div style="background:var(--gray-100);border-radius:var(--radius-md);padding:16px;margin-bottom:32px;font-size:.85rem;color:var(--gray-600);text-align:left;max-width:600px;margin-left:auto;margin-right:auto;font-family:monospace">
            <%=exception.getMessage()%>
        </div>
        <% } %>
        <div style="display:flex;gap:16px;justify-content:center;flex-wrap:wrap">
            <a href="index.html" class="btn btn-primary">Go to Homepage</a>
            <a href="javascript:history.back()" class="btn btn-dark">Go Back</a>
        </div>
    </div>
</div>
<script src="js/script.js"></script>
</body>
</html>