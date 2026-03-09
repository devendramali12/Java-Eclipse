<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.TravelPackage,model.User"%>
<!-- booking.jsp | Location: src/main/webapp/booking.jsp -->
<%
    if(session.getAttribute("user")==null){response.sendRedirect("login.jsp");return;}
    User user=(User)session.getAttribute("user");
    TravelPackage pkg=(TravelPackage)request.getAttribute("package");
    if(pkg==null){response.sendRedirect("packages.jsp");return;}
    String error=(String)request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Book Package &mdash; WanderLux</title><link rel="stylesheet" href="css/style.css"></head>
<body>
<nav class="navbar">
    <div class="navbar-brand">&#10022; Wander<span>Lux</span></div>
    <div class="navbar-links"><a href="index.html">Home</a><a href="packages.jsp">Packages</a><a href="my-bookings.jsp">My Bookings</a><a href="LogoutServlet">Logout</a></div>
</nav>
<div class="booking-page">
    <div style="max-width:1000px;margin:0 auto">
        <div style="margin-bottom:32px"><a href="packages.jsp" style="color:var(--gold);font-size:.88rem">&larr; Back to Packages</a><h2 style="margin-top:12px">Complete Your Booking</h2></div>
        <div class="booking-grid">
            <div>
                <% if(error!=null&&!error.isEmpty()){ %><div class="alert alert-error"><span>&#9888;</span> <%=error%></div><% } %>
                <div class="panel">
                    <div class="panel-header"><span class="panel-title">Traveller Details</span></div>
                    <div class="panel-body">
                        <div style="display:flex;gap:16px;align-items:center;margin-bottom:24px;padding:16px;background:var(--white);border-radius:var(--radius-sm)">
                            <div style="width:44px;height:44px;background:var(--gold);border-radius:50%;display:flex;align-items:center;justify-content:center;font-size:1.2rem;flex-shrink:0">&#128100;</div>
                            <div><div style="font-weight:600;color:var(--navy)"><%=user.getName()%></div><div style="font-size:.85rem;color:var(--gray-400)"><%=user.getEmail()%></div></div>
                        </div>
                        <form action="BookingServlet" method="post" onsubmit="return validateBookingForm()">
                            <input type="hidden" name="packageId" value="<%=pkg.getId()%>">
                            <div class="form-group"><label for="travelDate">Travel Date</label><input type="date" id="travelDate" name="travelDate" required></div>
                            <div class="form-group"><label for="people">Number of Travellers</label><input type="number" id="people" name="people" min="1" max="20" value="1" required></div>
                            <span id="packagePrice" data-price="<%=pkg.getPrice()%>" style="display:none"></span>
                            <button type="submit" class="btn btn-primary btn-full" style="margin-top:8px">Confirm Booking &rarr;</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="booking-summary">
                <h3>Booking Summary</h3>
                <div class="summary-row"><span class="label">Package</span><span class="value"><%=pkg.getPackageName()%></span></div>
                <div class="summary-row"><span class="label">Destination</span><span class="value">&#128205; <%=pkg.getLocation()%></span></div>
                <div class="summary-row"><span class="label">Duration</span><span class="value"><%=pkg.getDuration()%></span></div>
                <div class="summary-row"><span class="label">Price / Person</span><span class="value">&#8377;<%=String.format("%,.0f",pkg.getPrice())%></span></div>
                <div class="summary-row"><span class="label">Travellers</span><span class="value" id="peopleCount">1</span></div>
                <div class="summary-row summary-total"><span class="label">Total Amount</span><span class="value" id="totalPrice">&#8377;<%=String.format("%,.0f",pkg.getPrice())%></span></div>
                <div style="margin-top:24px;padding:16px;background:rgba(201,168,76,.1);border-radius:var(--radius-sm);font-size:.82rem;color:rgba(248,245,240,.7)">
                    &#10022; Free cancellation up to 48 hrs before travel<br><br>&#10022; Confirmation sent to your email
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/script.js"></script>
<script>document.getElementById('people').addEventListener('input',function(){document.getElementById('peopleCount').textContent=this.value||1;});</script>
</body></html>