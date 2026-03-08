<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="../header.jsp" />

<div class="main-container">
    <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:1.5rem;flex-wrap:wrap;gap:1rem">
        <h1 class="page-title" style="margin:0">
            <i class="fas fa-tags" style="color:var(--saffron)"></i> Category Management
        </h1>
        <div style="display:flex;gap:.8rem">
            <a href="${pageContext.request.contextPath}/admin/dashboard" class="btn-secondary">
                <i class="fas fa-tachometer-alt"></i> Dashboard
            </a>
            <a href="${pageContext.request.contextPath}/admin/categories/add" class="btn-primary">
                <i class="fas fa-plus"></i> Add Category
            </a>
        </div>
    </div>

    <c:if test="${param.msg == 'saved'}">
        <div class="alert alert-success"><i class="fas fa-check-circle"></i> Category saved successfully!</div>
    </c:if>
    <c:if test="${param.msg == 'deleted'}">
        <div class="alert alert-info"><i class="fas fa-trash-alt"></i> Category deleted.</div>
    </c:if>
    <c:if test="${param.msg == 'toggled'}">
        <div class="alert alert-info"><i class="fas fa-sync-alt"></i> Category status updated.</div>
    </c:if>
    <c:if test="${param.msg == 'hasproducts'}">
        <div class="alert alert-error">
            <i class="fas fa-exclamation-triangle"></i>
            Cannot delete — this category still has products linked. Reassign or delete those products first.
        </div>
    </c:if>

    <div class="stats-bar">
        <span>Total Categories: <strong>${categories.size()}</strong></span>
    </div>

    <div class="cat-grid">
        <c:forEach var="cat" items="${categories}">
            <div class="cat-card ${!cat.active ? 'cat-inactive' : ''}">
                <div class="cat-emoji">${cat.emoji}</div>
                <div class="cat-info">
                    <div class="cat-name">
                        ${cat.categoryName}
                        <c:if test="${!cat.active}">
                            <span class="cat-inactive-badge">INACTIVE</span>
                        </c:if>
                    </div>
                    <div class="cat-desc">${cat.description}</div>
                    <div class="cat-meta">
                        <span><i class="fas fa-box" style="color:var(--saffron)"></i> ${cat.productCount} products</span>
                        <span style="color:var(--text-soft)">ID: ${cat.categoryId}</span>
                    </div>
                </div>
                <div class="cat-actions">
                    <a href="${pageContext.request.contextPath}/admin/categories/edit?id=${cat.categoryId}"
                       class="btn-secondary" style="padding:.35rem .8rem;font-size:.8rem">
                        <i class="fas fa-edit"></i> Edit
                    </a>
                    <a href="${pageContext.request.contextPath}/admin/categories/toggle?id=${cat.categoryId}"
                       class="btn-secondary" style="padding:.35rem .8rem;font-size:.8rem">
                        <i class="fas fa-toggle-${cat.active ? 'on' : 'off'}"
                           style="color:${cat.active ? 'var(--success)' : 'var(--text-soft)'}"></i>
                        ${cat.active ? 'Disable' : 'Enable'}
                    </a>
                    <a href="${pageContext.request.contextPath}/admin/categories/delete?id=${cat.categoryId}"
                       class="btn-danger" style="padding:.35rem .8rem;font-size:.8rem"
                       onclick="return confirm('Delete \'${cat.categoryName}\'? Will fail if products are linked.')">
                        <i class="fas fa-trash"></i>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<style>
.cat-grid{display:grid;grid-template-columns:repeat(auto-fill,minmax(340px,1fr));gap:1.2rem}
.cat-card{background:var(--white);border:1.5px solid var(--border);border-radius:var(--radius-md);padding:1.2rem 1.3rem;display:flex;align-items:flex-start;gap:1rem;box-shadow:var(--shadow-sm);transition:var(--transition)}
.cat-card:hover{box-shadow:var(--shadow-md);transform:translateY(-2px)}
.cat-inactive{opacity:.6;background:var(--cream)}
.cat-emoji{font-size:2.2rem;flex-shrink:0;width:52px;height:52px;display:flex;align-items:center;justify-content:center;background:var(--cream);border-radius:12px}
.cat-info{flex:1;min-width:0}
.cat-name{font-weight:700;font-size:1rem;color:var(--navy);margin-bottom:.25rem;display:flex;align-items:center;gap:.5rem;flex-wrap:wrap}
.cat-inactive-badge{background:#fee2e2;color:#991b1b;font-size:.65rem;font-weight:700;padding:.1rem .45rem;border-radius:50px;letter-spacing:.3px}
.cat-desc{font-size:.82rem;color:var(--text-soft);margin-bottom:.5rem;line-height:1.4}
.cat-meta{display:flex;gap:1rem;font-size:.78rem;color:var(--text-mid)}
.cat-actions{display:flex;flex-direction:column;gap:.4rem;flex-shrink:0}
</style>

<jsp:include page="../footer.jsp" />