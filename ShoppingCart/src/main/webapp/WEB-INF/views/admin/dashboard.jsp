<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="../header.jsp" />

<div class="main-container">
    <h1 class="page-title">
        <i class="fas fa-tachometer-alt" style="color:var(--saffron)"></i> Admin Dashboard
    </h1>

    <!-- STAT CARDS -->
    <div class="dash-stats">
        <div class="stat-card" style="--accent:#1a2744">
            <div class="sc-icon"><i class="fas fa-box"></i></div>
            <div class="sc-body"><div class="sc-number">${totalProducts}</div><div class="sc-label">Products</div></div>
            <a href="${pageContext.request.contextPath}/admin/products" class="sc-link">Manage →</a>
        </div>
        <div class="stat-card" style="--accent:#e8872a">
            <div class="sc-icon" style="background:linear-gradient(135deg,#e8872a,#f5a14e)"><i class="fas fa-shopping-bag"></i></div>
            <div class="sc-body"><div class="sc-number">${totalOrders}</div><div class="sc-label">Total Orders</div></div>
            <a href="${pageContext.request.contextPath}/admin/orders" class="sc-link">Manage →</a>
        </div>
        <div class="stat-card" style="--accent:#2d7a4f">
            <div class="sc-icon" style="background:linear-gradient(135deg,#2d7a4f,#38a169)"><i class="fas fa-users"></i></div>
            <div class="sc-body"><div class="sc-number">${totalUsers}</div><div class="sc-label">Users</div></div>
            <a href="${pageContext.request.contextPath}/admin/users" class="sc-link">Manage →</a>
        </div>
        <div class="stat-card" style="--accent:#6b46c1">
            <div class="sc-icon" style="background:linear-gradient(135deg,#6b46c1,#9f7aea)"><i class="fas fa-tags"></i></div>
            <div class="sc-body"><div class="sc-number">${totalCategories}</div><div class="sc-label">Categories</div></div>
            <a href="${pageContext.request.contextPath}/admin/categories" class="sc-link">Manage →</a>
        </div>
        <div class="stat-card" style="--accent:#c05621">
            <div class="sc-icon" style="background:linear-gradient(135deg,#c05621,#dd6b20)"><i class="fas fa-rupee-sign"></i></div>
            <div class="sc-body">
                <div class="sc-number">&#8377;<fmt:formatNumber value="${totalRevenue}" pattern="#,##0"/></div>
                <div class="sc-label">Total Revenue</div>
            </div>
            <span class="sc-link" style="cursor:default">Delivered</span>
        </div>
    </div>

    <!-- TODAY STRIP -->
    <div class="today-strip">
        <div class="today-item">
            <span class="ti-icon">&#128197;</span>
            <div><div class="ti-val">${todayOrders}</div><div class="ti-label">Orders Today</div></div>
        </div>
        <div class="today-divider"></div>
        <div class="today-item">
            <span class="ti-icon">&#128176;</span>
            <div>
                <div class="ti-val">&#8377;<fmt:formatNumber value="${todayRevenue}" pattern="#,##0.00"/></div>
                <div class="ti-label">Revenue Today</div>
            </div>
        </div>
        <div class="today-divider"></div>
        <div class="today-item">
            <span class="ti-icon" style="color:${lowStock.size() > 0 ? '#e53e3e' : '#38a169'}">
                ${lowStock.size() > 0 ? '&#9888;&#65039;' : '&#9989;'}
            </span>
            <div>
                <div class="ti-val" style="color:${lowStock.size() > 0 ? '#e53e3e' : '#38a169'}">${lowStock.size()}</div>
                <div class="ti-label">Low Stock Alerts</div>
            </div>
        </div>
    </div>

    <!-- CHARTS ROW 1 -->
    <div class="chart-row">
        <div class="chart-box wide">
            <div class="chart-box-header"><i class="fas fa-chart-bar"></i> Monthly Revenue — Last 6 Months</div>
            <div class="chart-box-body"><canvas id="revenueChart"></canvas></div>
        </div>
        <div class="chart-box">
            <div class="chart-box-header"><i class="fas fa-chart-pie"></i> Orders by Status</div>
            <div class="chart-box-body center-content"><canvas id="statusChart"></canvas></div>
        </div>
    </div>

    <!-- CHARTS ROW 2 -->
    <div class="chart-row">
        <div class="chart-box">
            <div class="chart-box-header"><i class="fas fa-chart-bar"></i> Revenue by Category</div>
            <div class="chart-box-body"><canvas id="categoryChart"></canvas></div>
        </div>
        <div class="chart-box wide">
            <div class="chart-box-header"><i class="fas fa-trophy"></i> Top 5 Best-Selling Products</div>
            <div class="chart-box-body" style="padding:0">
                <c:if test="${empty topProducts}">
                    <p style="padding:2rem;text-align:center;color:var(--text-soft)">No orders yet.</p>
                </c:if>
                <c:forEach var="p" items="${topProducts}" varStatus="s">
                    <div class="top-row">
                        <div class="top-rank">#${s.index + 1}</div>
                        <div class="top-name">${p[0]}</div>
                        <div class="top-sold">${p[1]} sold</div>
                        <div class="top-rev">&#8377;<fmt:formatNumber value="${p[2]}" pattern="#,##0"/></div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <!-- ALERTS + QUICK ACTIONS -->
    <div class="chart-row">
        <div class="chart-box">
            <div class="chart-box-header" style="${lowStock.size() > 0 ? 'background:linear-gradient(135deg,#c53030,#e53e3e)' : ''}">
                <i class="fas fa-exclamation-triangle"></i> Low Stock Alerts
                <span class="badge-pill">${lowStock.size()} items</span>
            </div>
            <div class="chart-box-body" style="padding:0;max-height:240px;overflow-y:auto">
                <c:if test="${empty lowStock}">
                    <p style="padding:1.5rem;text-align:center;color:var(--success)">
                        <i class="fas fa-check-circle"></i> All products well stocked!
                    </p>
                </c:if>
                <c:forEach var="item" items="${lowStock}">
                    <div class="ls-row">
                        <span class="ls-name">${item[0]}</span>
                        <span class="ls-qty ${item[1] == '0' ? 'ls-out' : 'ls-low'}">
                            ${item[1] == '0' ? '&#128683; Out' : '&#9888;&#65039; '.concat(item[1])}
                        </span>
                    </div>
                </c:forEach>
            </div>
            <div class="chart-box-footer">
                <a href="${pageContext.request.contextPath}/admin/products" class="btn-primary"
                   style="width:100%;justify-content:center;padding:.5rem">
                    <i class="fas fa-cubes"></i> Update Stock
                </a>
            </div>
        </div>

        <div class="chart-box wide">
            <div class="chart-box-header"><i class="fas fa-bolt"></i> Quick Actions</div>
            <div class="chart-box-body">
                <div class="quick-grid">
                    <a href="${pageContext.request.contextPath}/admin/products/add" class="quick-btn navy"><i class="fas fa-plus"></i> Add Product</a>
                    <a href="${pageContext.request.contextPath}/admin/products"     class="quick-btn"><i class="fas fa-boxes"></i> Products</a>
                    <a href="${pageContext.request.contextPath}/admin/orders"       class="quick-btn"><i class="fas fa-list-alt"></i> Orders</a>
                    <a href="${pageContext.request.contextPath}/admin/categories"   class="quick-btn saffron"><i class="fas fa-tags"></i> Categories</a>
                    <a href="${pageContext.request.contextPath}/admin/users"        class="quick-btn"><i class="fas fa-users"></i> Users</a>
                    <a href="${pageContext.request.contextPath}/products"           class="quick-btn"><i class="fas fa-store"></i> View Store</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.umd.min.js"></script>
<script>
const GRID = 'rgba(0,0,0,.06)';

new Chart(document.getElementById('revenueChart'), {
    type: 'bar',
    data: {
        labels: [<c:forEach var="e" items="${monthlyRevenue}" varStatus="s">"${e.key}"<c:if test="${!s.last}">,</c:if></c:forEach>],
        datasets: [{ label: 'Revenue (&#8377;)',
            data: [<c:forEach var="e" items="${monthlyRevenue}" varStatus="s">${e.value}<c:if test="${!s.last}">,</c:if></c:forEach>],
            backgroundColor:'rgba(232,135,42,.8)', borderColor:'#e8872a', borderWidth:2, borderRadius:6 }]
    },
    options: { responsive:true, plugins:{legend:{display:false}},
        scales:{ y:{beginAtZero:true,grid:{color:GRID},ticks:{callback:v=>'&#8377;'+Number(v).toLocaleString('en-IN')}}, x:{grid:{display:false}} } }
});

new Chart(document.getElementById('statusChart'), {
    type: 'doughnut',
    data: {
        labels: [<c:forEach var="e" items="${statusCounts}" varStatus="s">"${e.key}"<c:if test="${!s.last}">,</c:if></c:forEach>],
        datasets: [{ data:[<c:forEach var="e" items="${statusCounts}" varStatus="s">${e.value}<c:if test="${!s.last}">,</c:if></c:forEach>],
            backgroundColor:['#f6e05e','#63b3ed','#b794f4','#68d391','#fc8181'], borderWidth:2, hoverOffset:6 }]
    },
    options: { responsive:true, plugins:{legend:{position:'bottom',labels:{font:{family:'DM Sans',size:11},padding:14}}}, cutout:'62%' }
});

new Chart(document.getElementById('categoryChart'), {
    type: 'bar',
    data: {
        labels: [<c:forEach var="e" items="${revenueByCategory}" varStatus="s">"${e.key}"<c:if test="${!s.last}">,</c:if></c:forEach>],
        datasets: [{ label: 'Revenue',
            data:[<c:forEach var="e" items="${revenueByCategory}" varStatus="s">${e.value}<c:if test="${!s.last}">,</c:if></c:forEach>],
            backgroundColor:['rgba(26,39,68,.75)','rgba(232,135,42,.75)','rgba(107,70,193,.75)',
                'rgba(45,122,79,.75)','rgba(192,86,33,.75)','rgba(49,130,206,.75)',
                'rgba(197,48,48,.75)','rgba(44,122,123,.75)'], borderRadius:5 }]
    },
    options: { indexAxis:'y', responsive:true, plugins:{legend:{display:false}},
        scales:{ x:{beginAtZero:true,grid:{color:GRID},ticks:{callback:v=>'&#8377;'+Number(v).toLocaleString('en-IN')}}, y:{grid:{display:false}} } }
});
</script>

<style>
.dash-stats{display:grid;grid-template-columns:repeat(5,1fr);gap:1rem;margin-bottom:1.5rem}
.stat-card{background:var(--white);border:1px solid var(--border);border-radius:var(--radius-md);padding:1.2rem 1.1rem;display:flex;flex-wrap:wrap;align-items:center;gap:.8rem;box-shadow:var(--shadow-sm);transition:var(--transition);position:relative;overflow:hidden}
.stat-card::before{content:'';position:absolute;left:0;top:0;bottom:0;width:4px;background:var(--accent,var(--navy))}
.stat-card:hover{transform:translateY(-3px);box-shadow:var(--shadow-md)}
.sc-icon{width:46px;height:46px;border-radius:10px;display:flex;align-items:center;justify-content:center;color:#fff;font-size:1.1rem;flex-shrink:0;background:linear-gradient(135deg,var(--navy),var(--navy-mid))}
.sc-body{flex:1;min-width:0}
.sc-number{font-family:'Playfair Display',serif;font-size:1.4rem;font-weight:700;color:var(--navy);line-height:1}
.sc-label{font-size:.75rem;color:var(--text-soft);margin-top:.2rem}
.sc-link{font-size:.75rem;color:var(--saffron);text-decoration:none;font-weight:600;width:100%}
.sc-link:hover{text-decoration:underline}
.today-strip{display:flex;background:var(--navy);border-radius:var(--radius-md);padding:1rem 2rem;margin-bottom:1.5rem;gap:2rem;align-items:center;flex-wrap:wrap}
.today-item{display:flex;align-items:center;gap:.8rem}
.ti-icon{font-size:1.6rem}
.ti-val{font-family:'Playfair Display',serif;font-size:1.3rem;font-weight:700;color:#fff;line-height:1}
.ti-label{font-size:.75rem;color:rgba(255,255,255,.5);margin-top:.2rem}
.today-divider{width:1px;background:rgba(255,255,255,.15);height:40px}
.chart-row{display:grid;grid-template-columns:1fr 2fr;gap:1.5rem;margin-bottom:1.5rem}
.chart-box{background:var(--white);border:1px solid var(--border);border-radius:var(--radius-md);overflow:hidden;box-shadow:var(--shadow-sm)}
.chart-box-header{background:linear-gradient(135deg,var(--navy),var(--navy-mid));color:#fff;padding:.85rem 1.3rem;font-size:.88rem;font-weight:600;display:flex;align-items:center;gap:.5rem}
.chart-box-body{padding:1.2rem}
.chart-box-body.center-content{display:flex;align-items:center;justify-content:center}
.chart-box-footer{padding:.8rem 1.2rem;border-top:1px solid var(--border)}
.badge-pill{margin-left:auto;background:rgba(255,255,255,.2);padding:.15rem .7rem;border-radius:50px;font-size:.75rem}
.top-row{display:grid;grid-template-columns:32px 1fr 90px 100px;align-items:center;gap:.8rem;padding:.75rem 1.2rem;border-bottom:1px solid var(--border);font-size:.85rem}
.top-row:last-child{border-bottom:none}
.top-rank{background:var(--navy);color:#fff;border-radius:50%;width:24px;height:24px;display:flex;align-items:center;justify-content:center;font-size:.72rem;font-weight:700}
.top-name{font-weight:500;color:var(--text-dark);overflow:hidden;white-space:nowrap;text-overflow:ellipsis}
.top-sold{background:var(--cream);color:var(--saffron);font-size:.75rem;font-weight:700;padding:.2rem .65rem;border-radius:50px;text-align:center}
.top-rev{font-weight:700;color:var(--navy);text-align:right}
.ls-row{display:flex;justify-content:space-between;align-items:center;padding:.65rem 1.2rem;border-bottom:1px solid var(--border);font-size:.85rem}
.ls-row:last-child{border-bottom:none}
.ls-name{font-weight:500;flex:1;color:var(--text-dark);margin-right:.8rem;overflow:hidden;white-space:nowrap;text-overflow:ellipsis}
.ls-qty{font-size:.78rem;font-weight:700;padding:.2rem .65rem;border-radius:50px;flex-shrink:0}
.ls-out{background:#fff5f5;color:#c53030}
.ls-low{background:#fffbeb;color:#92400e}
.quick-grid{display:grid;grid-template-columns:repeat(3,1fr);gap:.8rem}
.quick-btn{display:flex;align-items:center;justify-content:center;gap:.5rem;padding:.75rem .5rem;border-radius:var(--radius-sm);text-decoration:none;font-size:.82rem;font-weight:600;color:var(--navy);background:var(--cream);border:1.5px solid var(--border);transition:var(--transition)}
.quick-btn:hover{background:var(--navy);color:#fff;border-color:var(--navy);transform:translateY(-2px)}
.quick-btn.navy{background:var(--navy);color:#fff;border-color:var(--navy)}
.quick-btn.navy:hover{background:var(--saffron);border-color:var(--saffron)}
.quick-btn.saffron{background:rgba(232,135,42,.1);color:var(--saffron);border-color:rgba(232,135,42,.35)}
.quick-btn.saffron:hover{background:var(--saffron);color:#fff;border-color:var(--saffron)}
@media(max-width:1200px){.dash-stats{grid-template-columns:repeat(3,1fr)}}
@media(max-width:900px){.dash-stats{grid-template-columns:repeat(2,1fr)}.chart-row{grid-template-columns:1fr}.quick-grid{grid-template-columns:repeat(2,1fr)}}
@media(max-width:600px){.dash-stats{grid-template-columns:1fr}.today-strip{flex-direction:column;gap:1rem}.today-divider{width:100%;height:1px}}
</style>

<jsp:include page="../footer.jsp" />