<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register — ShopEase</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600;700&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
</head>
<body class="auth-page">
<div class="auth-container">
    <div class="auth-card wide-card">
        <div class="auth-logo">Shop<span>Ease</span></div>
        <div class="auth-divider"></div>
        <h2>Create Your Account</h2>
        <p class="auth-subtitle">Join thousands of happy shoppers</p>

        <c:if test="${not empty error}">
            <div class="alert alert-error"><i class="fas fa-exclamation-circle"></i> ${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post" id="registerForm">

            <div class="form-row">
                <div class="form-group">
                    <label><i class="fas fa-id-card"></i> Full Name</label>
                    <input type="text" name="fullName" 
                           value="${param.fullName}" required minlength="3" maxlength="100">
                </div>
                <div class="form-group">
                    <label><i class="fas fa-at"></i> Username</label>
                    <input type="text" name="username" id="username"
                           
                           value="${param.username}"
                           required minlength="3" maxlength="50"
                           pattern="[a-zA-Z0-9_]+"
                           title="Only letters, numbers and underscore">
                    <span class="input-hint" id="usernameHint">Letters, numbers, underscore only</span>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label><i class="fas fa-envelope"></i> Email Address</label>
                    <input type="email" name="email" 
                           value="${param.email}" required maxlength="100">
                </div>
                <div class="form-group">
                    <label><i class="fas fa-phone"></i> Phone Number</label>
                    <input type="tel" name="phone" id="phoneInput"
                          
                           value="${param.phone}"
                           pattern="[0-9]{10}" maxlength="10">
                    <span class="input-hint">Optional — 10 digits only</span>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label><i class="fas fa-lock"></i> Password</label>
                    <input type="password" name="password" id="password"
                            required minlength="6" maxlength="50">
                    <div class="password-strength" id="strengthMeter" style="display:none">
                        <div class="strength-bar"><div class="strength-fill" id="strengthFill"></div></div>
                        <span class="strength-text" id="strengthText"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label><i class="fas fa-lock"></i> Confirm Password</label>
                    <input type="password" name="confirmPassword" id="confirmPassword"
                            required minlength="6">
                    <span class="input-hint" id="matchHint"></span>
                </div>
            </div>

            <div class="form-group">
                <label><i class="fas fa-map-marker-alt"></i> Shipping Address</label>
                <textarea name="address" 
                          rows="2" maxlength="300">${param.address}</textarea>
                <span class="input-hint">Used as default address at checkout</span>
            </div>

            <div class="form-group" style="display:flex;align-items:center;gap:.6rem;margin-bottom:1rem">
                <input type="checkbox" id="terms" required
                       style="width:16px;height:16px;accent-color:var(--navy);cursor:pointer">
                <label for="terms" style="font-size:.83rem;text-transform:none;letter-spacing:0;color:var(--text-mid);margin:0;cursor:pointer">
                    I agree to the <a href="#" style="color:var(--saffron)">Terms of Service</a> and
                    <a href="#" style="color:var(--saffron)">Privacy Policy</a>
                </label>
            </div>

            <button type="submit" class="btn-primary full-width" id="submitBtn">
                <i class="fas fa-user-plus"></i> Create My Account
            </button>
        </form>

        <p class="auth-footer">Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in here</a></p>
    </div>
</div>

<script>
const passwordInput = document.getElementById('password');
const confirmInput  = document.getElementById('confirmPassword');
const strengthMeter = document.getElementById('strengthMeter');
const strengthFill  = document.getElementById('strengthFill');
const strengthText  = document.getElementById('strengthText');
const matchHint     = document.getElementById('matchHint');

passwordInput.addEventListener('input', function() {
    const val = this.value;
    if (!val) { strengthMeter.style.display = 'none'; return; }
    strengthMeter.style.display = 'block';
    let score = 0;
    if (val.length >= 6)  score++;
    if (val.length >= 10) score++;
    if (/[A-Z]/.test(val)) score++;
    if (/[0-9]/.test(val)) score++;
    if (/[^A-Za-z0-9]/.test(val)) score++;
    const levels = [
        { label: 'Very Weak',   color: '#e53e3e', width: '15%'  },
        { label: 'Weak',        color: '#dd6b20', width: '30%'  },
        { label: 'Fair',        color: '#d69e2e', width: '55%'  },
        { label: 'Strong',      color: '#38a169', width: '80%'  },
        { label: 'Very Strong', color: '#2d7a4f', width: '100%' }
    ];
    const level = levels[Math.min(score, 4)];
    strengthFill.style.width      = level.width;
    strengthFill.style.background = level.color;
    strengthText.textContent      = level.label;
    strengthText.style.color      = level.color;
});

confirmInput.addEventListener('input', function() {
    if (!this.value) { matchHint.textContent = ''; return; }
    if (this.value === passwordInput.value) {
        matchHint.textContent = '✓ Passwords match';
        matchHint.style.color = '#38a169';
    } else {
        matchHint.textContent = '✗ Passwords do not match';
        matchHint.style.color = '#e53e3e';
    }
});

document.getElementById('registerForm').addEventListener('submit', function(e) {
    if (passwordInput.value !== confirmInput.value) {
        e.preventDefault();
        matchHint.textContent = '✗ Passwords do not match';
        matchHint.style.color = '#e53e3e';
        confirmInput.focus();
        return;
    }
    const btn = document.getElementById('submitBtn');
    btn.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Creating Account...';
    btn.disabled  = true;
});

document.getElementById('username').addEventListener('input', function() {
    const hint = document.getElementById('usernameHint');
    if (this.value && !/^[a-zA-Z0-9_]+$/.test(this.value)) {
        hint.textContent = '✗ Only letters, numbers, underscore allowed';
        hint.style.color = '#e53e3e';
    } else {
        hint.textContent = 'Letters, numbers, underscore only';
        hint.style.color = '';
    }
});

document.getElementById('phoneInput').addEventListener('input', function() {
    this.value = this.value.replace(/\D/g, '').slice(0, 10);
});
</script>
</body>
</html>