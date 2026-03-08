<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="../header.jsp" />
<div class="main-container">
    <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:1.5rem">
        <h1 class="page-title" style="margin:0"><i class="fas fa-box" style="color:var(--saffron)"></i> Manage Products</h1>
        <a href="${pageContext.request.contextPath}/admin/products/add" class="btn-primary"><i class="fas fa-plus"></i> Add Product</a>
    </div>
    <c:if test="${param.msg == 'saved'}">   <div class="alert alert-success"><i class="fas fa-check-circle"></i> Product saved successfully!</div></c:if>
    <c:if test="${param.msg == 'deleted'}"> <div class="alert alert-info"><i class="fas fa-trash"></i> Product deleted.</div></c:if>
    <table class="orders-table">
        <thead>
            <tr><th>ID</th><th>Image</th><th>Product Name</th><th>Category</th><th>Price</th><th>Stock</th><th>Actions</th></tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.productId}</td>
                    <td>
                        <c:if test="${not empty p.imageUrl}">
                            <img src="${p.imageUrl}" alt="${p.productName}"
                                 style="width:48px;height:48px;object-fit:cover;border-radius:8px"
                                 onerror="this.style.display='none'">
                        </c:if>
                    </td>
                    <td><strong>${p.productName}</strong></td>
                    <td>${p.categoryName}</td>
                    <td>&#8377;<fmt:formatNumber value="${p.price}" pattern="#,##0.00"/></td>
                    <td>
                        <span style="color:${p.stockQuantity > 0 ? 'var(--success)' : 'var(--danger)'}; font-weight:600">
                            ${p.stockQuantity}
                        </span>
                    </td>
                    <td style="display:flex;gap:.4rem;flex-wrap:wrap">
                        <a href="${pageContext.request.contextPath}/admin/products/edit?id=${p.productId}" class="btn-secondary" style="padding:.3rem .7rem;font-size:.8rem"><i class="fas fa-edit"></i> Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/products/delete?id=${p.productId}" class="btn-danger" style="padding:.3rem .7rem;font-size:.8rem" onclick="return confirm('Delete ${p.productName}?')"><i class="fas fa-trash"></i> Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../footer.jsp" />