<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.BookingDAO,model.Booking,model.User,java.util.List"%>
<!-- my-bookings.jsp | Location: src/main/webapp/my-bookings.jsp -->
<%
    if(session.getAttribute("user")==null){response.sendRedirect("login.jsp");return;}
    User user=(User)session.getAttribute("user");
    List<Booking> bookings=new BookingDAO().getBookingsByUser(user.getId());
    String bookingSuccess=(String)session.getAttribute("bookingSuccess");
    if(bookingSuccess!=null) session.removeAttribute("bookingSuccess");
%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>My Bookings &mdash; WanderLux</title><link rel="stylesheet" href="css/style.css"></head>
<body>
<nav class="navbar">
    <div class="navbar-brand">&#10022; Wander<span>Lux</span></div>
    <div class="navbar-links"><a href="index.html">Home</a><a href="packages.jsp">Packages</a><a href="my-bookings.jsp" class="active">My Bookings</a><a href="LogoutServlet">Logout</a></div>
</nav>
<div style="background:var(--navy);padding:120px 5% 60px">
    <div style="max-width:1200px;margin:0 auto">
        <span class="section-label">&#10022; Your Travel History</span>
        <h1 style="color:var(--white);margin:12px 0">My Bookings</h1>
        <p style="color:rgba(248,245,240,.6)">Welcome back, <strong style="color:var(--gold)"><%=user.getName()%></strong></p>
    </div>
</div>
<section class="section" style="max-width:1200px;margin:0 auto">
    <% if(bookingSuccess!=null){ %><div class="alert alert-success fade-in"><span>&#10003;</span> <%=bookingSuccess%></div><% } %>
    <% if(bookings.isEmpty()){ %>
    <div class="empty-state"><span class="emoji">&#129523;</span><h3>No bookings yet</h3>
    <p>You haven't booked any packages yet.<br><a href="packages.jsp" class="btn btn-primary" style="margin-top:20px;display:inline-flex">Explore Packages &rarr;</a></p></div>
    <% } else { %>
    <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:24px">
        <h3 style="font-family:var(--font-display)"><%=bookings.size()%> Booking<%=bookings.size()!=1?"s":""%></h3>
        <a href="packages.jsp" class="btn btn-primary btn-sm">+ New Booking</a>
    </div>
    <div class="table-wrapper">
        <table>
            <thead><tr><th>#</th><th>Package</th><th>Destination</th><th>Travel Date</th><th>Travellers</th><th>Status</th></tr></thead>
            <tbody>
                <% for(Booking b:bookings){ %>
                <tr>
                    <td style="color:var(--gray-400)"><%=b.getId()%></td>
                    <td><strong><%=b.getPackageName()%></strong></td>
                    <td>&#128205; <%=b.getLocation()%></td>
                    <td><%=b.getBookingDate()%></td>
                    <td><%=b.getPeople()%> person<%=b.getPeople()!=1?"s":""%></td>
                    <td><span class="badge badge-confirmed">Confirmed</span></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <% } %>
</section>
<footer><p>&copy; 2025 <a href="#">WanderLux</a> &middot; All rights reserved</p></footer>
<script src="js/script.js"></script></body></html>