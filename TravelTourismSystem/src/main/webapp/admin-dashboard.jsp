<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.PackageDAO,dao.BookingDAO,model.TravelPackage,model.Booking,java.util.List"%>
<!-- admin-dashboard.jsp | Location: src/main/webapp/admin-dashboard.jsp -->
<%
    if(session.getAttribute("admin")==null){response.sendRedirect("admin-login.jsp");return;}
    PackageDAO packageDAO=new PackageDAO();
    BookingDAO bookingDAO=new BookingDAO();
    List<TravelPackage> packages=packageDAO.getAllPackages();
    List<Booking> bookings=bookingDAO.getAllBookings();
    String adminMsg=(String)session.getAttribute("adminMsg");
    String adminError=(String)session.getAttribute("adminError");
    if(adminMsg!=null) session.removeAttribute("adminMsg");
    if(adminError!=null) session.removeAttribute("adminError");
    String activeTab=request.getParameter("tab");
    if(activeTab==null) activeTab="packages";
%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Admin Dashboard &mdash; WanderLux</title><link rel="stylesheet" href="css/style.css">
<style>
.modal-overlay{display:none;position:fixed;inset:0;background:rgba(0,0,0,.6);z-index:2000;align-items:center;justify-content:center;backdrop-filter:blur(4px)}
.modal-box{background:#fff;border-radius:var(--radius-lg);padding:36px;width:100%;max-width:540px;max-height:90vh;overflow-y:auto;animation:fadeUp .3s ease}
.modal-box h3{margin-bottom:24px;color:var(--navy)}
</style>
</head>
<body>
<div class="admin-layout">
<aside class="admin-sidebar">
    <div class="sidebar-header"><div class="sidebar-brand">&#10022; WanderLux <small>Admin Portal</small></div></div>
    <nav class="sidebar-nav">
        <a href="admin-dashboard.jsp?tab=packages" class="<%="packages".equals(activeTab)?"active":""%>"><span>&#128506;&#65039;</span> Packages</a>
        <a href="admin-dashboard.jsp?tab=bookings" class="<%="bookings".equals(activeTab)?"active":""%>"><span>&#128203;</span> All Bookings</a>
        <a href="admin-dashboard.jsp?tab=add" class="<%="add".equals(activeTab)?"active":""%>"><span>&#10133;</span> Add Package</a>
        <a href="index.html" style="margin-top:16px"><span>&#127758;</span> View Site</a>
        <a href="LogoutServlet"><span>&#128682;</span> Logout</a>
    </nav>
</aside>
<main class="admin-main">
    <div class="admin-topbar">
        <h1><% if("bookings".equals(activeTab)){ %>All Bookings<% } else if("add".equals(activeTab)){ %>Add New Package<% } else { %>Manage Packages<% } %></h1>
        <span style="font-size:.85rem;color:var(--gray-400)">Logged in as <strong>admin</strong></span>
    </div>
    <div class="admin-content">
        <% if(adminMsg!=null){ %><div class="alert alert-success"><span>&#10003;</span> <%=adminMsg%></div><% } %>
        <% if(adminError!=null){ %><div class="alert alert-error"><span>&#9888;</span> <%=adminError%></div><% } %>
        <div class="stats-grid">
            <div class="stat-card"><div class="stat-value"><%=packages.size()%></div><div class="stat-label">Total Packages</div></div>
            <div class="stat-card"><div class="stat-value"><%=bookings.size()%></div><div class="stat-label">Total Bookings</div></div>
            <div class="stat-card"><div class="stat-value"><%=bookings.stream().mapToInt(Booking::getPeople).sum()%></div><div class="stat-label">Total Travellers</div></div>
        </div>

        <% if("packages".equals(activeTab)){ %>
        <div class="panel">
            <div class="panel-header"><span class="panel-title">All Travel Packages</span><a href="admin-dashboard.jsp?tab=add" class="btn btn-primary btn-sm">+ Add Package</a></div>
            <div class="table-wrapper"><table>
                <thead><tr><th>ID</th><th>Package Name</th><th>Location</th><th>Price</th><th>Duration</th><th>Actions</th></tr></thead>
                <tbody>
                    <% for(TravelPackage p:packages){ %>
                    <tr>
                        <td style="color:var(--gray-400)">#<%=p.getId()%></td>
                        <td><strong><%=p.getPackageName()%></strong></td>
                        <td>&#128205; <%=p.getLocation()%></td>
                        <td>&#8377;<%=String.format("%,.0f",p.getPrice())%></td>
                        <td><%=p.getDuration()%></td>
                        <td style="display:flex;gap:8px;flex-wrap:wrap">
                            <button class="btn btn-sm btn-dark" onclick="openEditModal(<%=p.getId()%>,'<%=p.getPackageName().replace("'","\\'")%>','<%=p.getLocation().replace("'","\\'")%>','<%=p.getPrice()%>','<%=p.getDuration().replace("'","\\'")%>','<%=p.getDescription().replace("'","\\'").replace("\n"," ")%>','<%=p.getImageUrl()!=null?p.getImageUrl():""%>')">&#9999; Edit</button>
                            <button class="btn btn-sm btn-danger" onclick="confirmDelete(<%=p.getId()%>,'<%=p.getPackageName().replace("'","\\'")%>')">&#128465; Delete</button>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table></div>
        </div>

        <% } else if("bookings".equals(activeTab)){ %>
        <div class="panel">
            <div class="panel-header"><span class="panel-title">All Customer Bookings</span><span style="font-size:.85rem;color:var(--gray-400)"><%=bookings.size()%> total</span></div>
            <div class="table-wrapper"><table>
                <thead><tr><th>#</th><th>Customer</th><th>Package</th><th>Destination</th><th>Travel Date</th><th>Travellers</th><th>Status</th></tr></thead>
                <tbody>
                    <% for(Booking b:bookings){ %>
                    <tr>
                        <td style="color:var(--gray-400)"><%=b.getId()%></td>
                        <td><strong><%=b.getUserName()%></strong></td>
                        <td><%=b.getPackageName()%></td>
                        <td>&#128205; <%=b.getLocation()%></td>
                        <td><%=b.getBookingDate()%></td>
                        <td><%=b.getPeople()%></td>
                        <td><span class="badge badge-confirmed">Confirmed</span></td>
                    </tr>
                    <% } %>
                </tbody>
            </table></div>
        </div>

        <% } else if("add".equals(activeTab)){ %>
        <div class="panel" style="max-width:680px">
            <div class="panel-header"><span class="panel-title">Add New Travel Package</span></div>
            <div class="panel-body">
                <form action="AdminServlet" method="post" onsubmit="return validatePackageForm()">
                    <input type="hidden" name="action" value="add">
                    <div class="form-row">
                        <div class="form-group"><label for="packageName">Package Name</label><input type="text" id="packageName" name="packageName" placeholder="e.g. Rajasthan Heritage Tour" required></div>
                        <div class="form-group"><label for="location">Location</label><input type="text" id="location" name="location" placeholder="e.g. Jaipur, Rajasthan" required></div>
                    </div>
                    <div class="form-row">
                        <div class="form-group"><label for="price">Price (&#8377; per person)</label><input type="number" id="price" name="price" placeholder="25000" min="1" required></div>
                        <div class="form-group"><label for="duration">Duration</label><input type="text" id="duration" name="duration" placeholder="e.g. 4 Days / 3 Nights"></div>
                    </div>
                    <div class="form-group"><label for="description">Description</label><textarea id="description" name="description" placeholder="Describe the package highlights&hellip;"></textarea></div>
                    <div class="form-group"><label for="imageUrl">Image URL (optional)</label><input type="url" id="imageUrl" name="imageUrl" placeholder="https://images.unsplash.com/&hellip;"></div>
                    <button type="submit" class="btn btn-primary">Add Package &rarr;</button>
                </form>
            </div>
        </div>
        <% } %>
    </div>
</main>
</div>

<!-- Edit Modal -->
<div class="modal-overlay" id="editModal">
<div class="modal-box">
    <h3>&#9999; Edit Package</h3>
    <form action="AdminServlet" method="post" onsubmit="return validatePackageForm()">
        <input type="hidden" name="action" value="update">
        <input type="hidden" id="editPackageId" name="packageId">
        <div class="form-row">
            <div class="form-group"><label>Package Name</label><input type="text" id="editName" name="packageName" required></div>
            <div class="form-group"><label>Location</label><input type="text" id="editLocation" name="location" required></div>
        </div>
        <div class="form-row">
            <div class="form-group"><label>Price (&#8377;)</label><input type="number" id="editPrice" name="price" required></div>
            <div class="form-group"><label>Duration</label><input type="text" id="editDuration" name="duration"></div>
        </div>
        <div class="form-group"><label>Description</label><textarea id="editDescription" name="description"></textarea></div>
        <div class="form-group"><label>Image URL</label><input type="url" id="editImageUrl" name="imageUrl"></div>
        <div style="display:flex;gap:12px;margin-top:8px">
            <button type="submit" class="btn btn-primary">Save Changes</button>
            <button type="button" class="btn btn-dark" onclick="closeModal('editModal')">Cancel</button>
        </div>
    </form>
</div>
</div>
<script src="js/script.js"></script>
</body></html>