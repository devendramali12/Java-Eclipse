<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="header.jsp" />

<div class="main-container">
    <h1 class="page-title"><i class="fas fa-user-circle" style="color:var(--saffron)"></i> My Profile</h1>

    <div class="profile-layout">
        <!-- Update Profile -->
        <div class="profile-card">
            <div class="profile-card-header"><i class="fas fa-edit"></i> Edit Profile</div>
            <div class="profile-card-body">
                <c:if test="${not empty success}">
                    <div class="alert alert-success"><i class="fas fa-check-circle"></i> ${success}</div>
                </c:if>
                <c:if test="${not empty error}">
                    <div class="alert alert-error"><i class="fas fa-exclamation-circle"></i> ${error}</div>
                </c:if>
                <form action="${pageContext.request.contextPath}/profile" method="post">
                    <input type="hidden" name="action" value="updateProfile">
                    <div class="form-group">
                        <label><i class="fas fa-at"></i> Username</label>
                        <input type="text" value="${user.username}" readonly class="readonly-input">
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-envelope"></i> Email</label>
                        <input type="text" value="${user.email}" readonly class="readonly-input">
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-id-card"></i> Full Name</label>
                        <input type="text" name="fullName" value="${user.fullName}" required minlength="3">
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-phone"></i> Phone</label>
                        <input type="tel" name="phone" value="${user.phone}" pattern="[0-9]{10}" maxlength="10">
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-map-marker-alt"></i> Address</label>
                        <textarea name="address" rows="3">${user.address}</textarea>
                    </div>
                    <button type="submit" class="btn-primary full-width">
                        <i class="fas fa-save"></i> Save Changes
                    </button>
                </form>
            </div>
        </div>

        <!-- Change Password -->
        <div class="profile-card">
            <div class="profile-card-header"><i class="fas fa-lock"></i> Change Password</div>
            <div class="profile-card-body">
                <c:if test="${not empty pwdSuccess}">
                    <div class="alert alert-success"><i class="fas fa-check-circle"></i> ${pwdSuccess}</div>
                </c:if>
                <c:if test="${not empty pwdError}">
                    <div class="alert alert-error"><i class="fas fa-exclamation-circle"></i> ${pwdError}</div>
                </c:if>
                <form action="${pageContext.request.contextPath}/profile" method="post">
                    <input type="hidden" name="action" value="changePassword">
                    <div class="form-group">
                        <label><i class="fas fa-lock"></i> Current Password</label>
                        <input type="password" name="oldPassword" placeholder="Enter current password" required>
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-lock"></i> New Password</label>
                        <input type="password" name="newPassword" id="newPwd" placeholder="Min 6 characters" required minlength="6">
                    </div>
                    <div class="form-group">
                        <label><i class="fas fa-lock"></i> Confirm New Password</label>
                        <input type="password" name="confirmNewPassword" id="conPwd" placeholder="Repeat new password" required minlength="6">
                        <span class="input-hint" id="pwdMatch"></span>
                    </div>
                    <button type="submit" class="btn-primary full-width">
                        <i class="fas fa-key"></i> Update Password
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
document.getElementById('conPwd').addEventListener('input', function() {
    const hint = document.getElementById('pwdMatch');
    if (this.value === document.getElementById('newPwd').value) {
        hint.textContent = '✓ Passwords match'; hint.style.color = '#38a169';
    } else {
        hint.textContent = '✗ Does not match';  hint.style.color = '#e53e3e';
    }
});
</script>

<jsp:include page="footer.jsp" />