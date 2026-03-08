<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="../header.jsp" />
<div class="main-container">
    <h1 class="page-title">
        <i class="fas fa-${empty product ? 'plus' : 'edit'}" style="color:var(--saffron)"></i>
        ${empty product ? 'Add New Product' : 'Edit Product'}
    </h1>
    <div style="max-width:700px">
        <div class="checkout-card">
            <div class="checkout-card-header">
                <i class="fas fa-box"></i> Product Details
            </div>
            <div class="checkout-card-body">
                <form action="${pageContext.request.contextPath}/admin/products/save" method="post">
                    <c:if test="${not empty product}">
                        <input type="hidden" name="productId" value="${product.productId}">
                    </c:if>
                    <div class="form-row">
                        <div class="form-group">
                            <label><i class="fas fa-tag"></i> Product Name</label>
                            <input type="text" name="productName" value="${product.productName}" required maxlength="150">
                        </div>
                        <div class="form-group">
                            <label><i class="fas fa-th-list"></i> Category</label>
                            <select name="categoryId" style="width:100%;padding:.65rem 1rem;border:1.5px solid var(--border);border-radius:var(--radius-sm);font-family:'DM Sans',sans-serif;background:var(--ivory)">
                                <c:forEach var="cat" items="${categories}">
                                    <option value="${cat[0]}" ${product.categoryId == cat[0] ? 'selected' : ''}>${cat[1]}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-align-left"></i> Description</label>
                        <textarea name="description" rows="3" required>${product.description}</textarea>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label><i class="fas fa-rupee-sign"></i> Price (₹)</label>
                            <input type="number" name="price" value="${product.price}" required min="0" step="0.01">
                        </div>
                        <div class="form-group">
                            <label><i class="fas fa-cubes"></i> Stock Quantity</label>
                            <input type="number" name="stockQuantity" value="${product.stockQuantity}" required min="0">
                        </div>
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-image"></i> Image URL (Unsplash or any direct URL)</label>
                        <input type="url" name="imageUrl" value="${product.imageUrl}" placeholder="https://images.unsplash.com/...">
                        <span class="input-hint">Paste a direct image URL. Leave blank for emoji fallback.</span>
                    </div>
                    <c:if test="${not empty product.imageUrl}">
                        <div style="margin-bottom:1rem">
                            <img src="${product.imageUrl}" alt="Preview"
                                 style="height:100px;border-radius:10px;object-fit:cover"
                                 onerror="this.style.display='none'">
                        </div>
                    </c:if>
                    <div style="display:flex;gap:.8rem">
                        <button type="submit" class="btn-primary" style="flex:1"><i class="fas fa-save"></i> Save Product</button>
                        <a href="${pageContext.request.contextPath}/admin/products" class="btn-secondary" style="flex:0 0 auto"><i class="fas fa-times"></i> Cancel</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp" />