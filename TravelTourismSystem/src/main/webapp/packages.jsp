<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.PackageDAO,model.TravelPackage,java.util.List"%>
<!-- packages.jsp | Location: src/main/webapp/packages.jsp -->
<%
    String searchQuery=request.getParameter("search");
    PackageDAO packageDAO=new PackageDAO();
    List<TravelPackage> packages;
    if(searchQuery!=null&&!searchQuery.isBlank()) packages=packageDAO.searchPackages(searchQuery.trim());
    else packages=packageDAO.getAllPackages();
    boolean loggedIn=session.getAttribute("user")!=null;
    String userName=loggedIn?(String)session.getAttribute("userName"):null;
%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Travel Packages &mdash; WanderLux</title><link rel="stylesheet" href="css/style.css"></head>
<body>
<nav class="navbar">
    <div class="navbar-brand">&#10022; Wander<span>Lux</span></div>
    <div class="navbar-links">
        <a href="index.html">Home</a><a href="packages.jsp" class="active">Packages</a>
        <% if(loggedIn){ %><a href="my-bookings.jsp">My Bookings</a><a href="LogoutServlet">Logout (<%=userName%>)</a>
        <% } else { %><a href="login.jsp">Login</a><a href="register.jsp" class="btn-nav">Register</a><% } %>
    </div>
</nav>
<div style="background:var(--navy);padding:120px 5% 60px;text-align:center">
    <span class="section-label">&#10022; All Destinations</span>
    <h1 style="color:var(--white);margin:12px 0">Find Your Perfect <em style="color:var(--gold-light);font-style:italic">Escape</em></h1>
    <p style="color:rgba(248,245,240,.65);max-width:540px;margin:0 auto 32px"><%=packages.size()%> curated packages available.</p>
    <div style="max-width:560px;margin:0 auto">
        <div class="search-card">
            <span>&#128269;</span>
            <input type="text" id="searchInput" placeholder="Search packages or destinations&hellip;" value="<%=searchQuery!=null?searchQuery:""%>">
        </div>
    </div>
</div>
<section class="section" style="max-width:1300px;margin:0 auto">
    <% if(packages.isEmpty()){ %>
    <div class="empty-state"><span class="emoji">&#128506;&#65039;</span><h3>No packages found</h3>
    <p>Try a different search or <a href="packages.jsp" style="color:var(--gold)">view all packages</a>.</p></div>
    <% } else { %>
    <div class="packages-grid" id="packagesGrid">
        <% for(TravelPackage pkg:packages){
            String img=(pkg.getImageUrl()!=null&&!pkg.getImageUrl().isBlank())?pkg.getImageUrl():"https://images.unsplash.com/photo-1488085061387-422e29b40080?w=600&q=80"; %>
        <div class="package-card">
            <div class="card-image"><img src="<%=img%>" alt="<%=pkg.getPackageName()%>"><span class="card-badge"><%=pkg.getDuration()%></span></div>
            <div class="card-body">
                <div class="card-location">&#128205; <%=pkg.getLocation()%></div>
                <h3 class="card-title"><%=pkg.getPackageName()%></h3>
                <p class="card-desc"><%=pkg.getDescription()%></p>
                <div class="card-footer">
                    <div class="card-price">&#8377;<%=String.format("%,.0f",pkg.getPrice())%> <span>per person</span></div>
                    <% if(loggedIn){ %><a href="BookingServlet?packageId=<%=pkg.getId()%>" class="btn btn-primary btn-sm">Book Now &rarr;</a>
                    <% } else { %><a href="login.jsp" class="btn btn-primary btn-sm">Login to Book</a><% } %>
                </div>
            </div>
        </div>
        <% } %>
    </div>
    <div id="noResults" class="empty-state" style="display:none"><span class="emoji">&#128269;</span><p>No packages match your search.</p></div>
    <% } %>
</section>
<footer><p>&copy; 2025 <a href="#">WanderLux</a> &middot; All rights reserved</p></footer>
<script src="js/script.js"></script>
</body></html>