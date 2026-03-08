<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="../header.jsp" />

<div class="main-container">
    <div class="breadcrumb">
        <a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a>
        <i class="fas fa-chevron-right"></i>
        <a href="${pageContext.request.contextPath}/admin/categories">Categories</a>
        <i class="fas fa-chevron-right"></i>
        <span>${empty category ? 'Add New' : 'Edit'}</span>
    </div>

    <h1 class="page-title">
        <i class="fas fa-${empty category ? 'plus-circle' : 'edit'}" style="color:var(--saffron)"></i>
        ${empty category ? 'Add New Category' : 'Edit Category'}
    </h1>

    <div style="max-width:580px">
        <div class="checkout-card">
            <div class="checkout-card-header"><i class="fas fa-tags"></i> Category Details</div>
            <div class="checkout-card-body">
                <form action="${pageContext.request.contextPath}/admin/categories/save" method="post">
                    <c:if test="${not empty category}">
                        <input type="hidden" name="categoryId" value="${category.categoryId}">
                    </c:if>

                    <!-- Live Preview -->
                    <div class="cat-preview">
                        <div class="prev-emoji" id="previewEmoji">${empty category.emoji ? '&#128717;' : category.emoji}</div>
                        <div>
                            <div class="prev-name" id="previewName">${empty category.categoryName ? 'Category Name' : category.categoryName}</div>
                            <div class="prev-desc" id="previewDesc">${empty category.description ? 'Description here...' : category.description}</div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group">
                            <label><i class="fas fa-tag"></i> Category Name *</label>
                            <input type="text" name="categoryName" value="${category.categoryName}"
                                   placeholder="e.g. Electronics" required maxlength="100"
                                   oninput="document.getElementById('previewName').textContent=this.value||'Category Name'">
                        </div>
                        <div class="form-group">
                            <label><i class="fas fa-smile"></i> Emoji Icon</label>
                            <input type="text" name="emoji" id="emojiInput"
                                   value="${empty category.emoji ? '&#128717;' : category.emoji}"
                                   placeholder="&#128717;" maxlength="10"
                                   oninput="document.getElementById('previewEmoji').textContent=this.value||'&#128717;'"
                                   style="font-size:1.4rem;text-align:center;letter-spacing:.2rem">
                            <span class="input-hint">Click below to pick an emoji</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label><i class="fas fa-th"></i> Quick Pick Emoji</label>
                        <div class="emoji-picker">
                           <%-- ✅ REPLACE the Quick Pick Emoji form-group with this --%>
<div class="form-group">
    <label><i class="fas fa-th"></i> Quick Pick Emoji</label>
    <div class="emoji-picker">
        <button type="button" class="emoji-btn" onclick="setEmoji('📱')">📱</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('👕')">👕</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('📚')">📚</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🍳')">🍳</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('⚽')">⚽</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('💄')">💄</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🧸')">🧸</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('👟')">👟</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🏠')">🏠</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('📷')">📷</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🎮')">🎮</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🎵')">🎵</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🍕')">🍕</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🚗')">🚗</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('💊')">💊</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🌿')">🌿</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🎒')">🎒</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🧴')">🧴</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('👜')">👜</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🖥️')">🖥️</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🎨')">🎨</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🏋️')">🏋️</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🧁')">🧁</button>
        <button type="button" class="emoji-btn" onclick="setEmoji('🌸')">🌸</button>
    </div>
</div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label><i class="fas fa-align-left"></i> Description</label>
                        <textarea name="description" rows="3" maxlength="300"
                                  placeholder="Short description of this category..."
                                  oninput="document.getElementById('previewDesc').textContent=this.value||'Description here...'">${category.description}</textarea>
                    </div>

                    <div class="form-group" style="display:flex;align-items:center;gap:.7rem">
                        <input type="checkbox" name="isActive" id="isActive"
                               ${empty category || category.active ? 'checked' : ''}
                               style="width:18px;height:18px;accent-color:var(--navy);cursor:pointer">
                        <label for="isActive" style="font-size:.9rem;text-transform:none;letter-spacing:0;color:var(--text-dark);margin:0;cursor:pointer;font-weight:600">
                            Active — visible in product filters and dropdowns
                        </label>
                    </div>

                    <div style="display:flex;gap:.8rem">
                        <button type="submit" class="btn-primary" style="flex:1">
                            <i class="fas fa-save"></i>
                            ${empty category ? 'Create Category' : 'Save Changes'}
                        </button>
                        <a href="${pageContext.request.contextPath}/admin/categories"
                           class="btn-secondary" style="flex:0 0 auto;padding:.75rem 1.5rem">
                            <i class="fas fa-times"></i> Cancel
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
function setEmoji(e) {
    document.getElementById('emojiInput').value = e;
    document.getElementById('previewEmoji').textContent = e;
}
</script>

<style>
.cat-preview{display:flex;align-items:center;gap:1rem;background:linear-gradient(135deg,var(--navy),var(--navy-mid));border-radius:var(--radius-md);padding:1.2rem 1.5rem;margin-bottom:1.5rem}
.prev-emoji{font-size:2.8rem;width:60px;text-align:center;flex-shrink:0}
.prev-name{font-family:'Playfair Display',serif;font-size:1.2rem;font-weight:700;color:#fff}
.prev-desc{font-size:.82rem;color:rgba(255,255,255,.55);margin-top:.2rem}
.emoji-picker{display:flex;flex-wrap:wrap;gap:.4rem}
.emoji-btn{width:38px;height:38px;font-size:1.3rem;cursor:pointer;background:var(--cream);border:1.5px solid var(--border);border-radius:8px;transition:var(--transition);display:flex;align-items:center;justify-content:center}
.emoji-btn:hover{transform:scale(1.25);border-color:var(--saffron);background:var(--white)}
</style>

<jsp:include page="../footer.jsp" />