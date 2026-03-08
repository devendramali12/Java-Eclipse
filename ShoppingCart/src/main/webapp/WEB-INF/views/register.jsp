<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register — ShopEase</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600;700&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

        :root {
            --navy:      #1a2744;
            --navy-mid:  #253460;
            --saffron:   #e8872a;
            --ivory:     #faf8f4;
            --white:     #ffffff;
            --border:    #e8e0d4;
            --text-soft: #8a7f72;
            --success:   #2d7a4f;
            --error:     #c53030;
        }

        body {
            font-family: 'DM Sans', sans-serif;
            background: var(--ivory);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 1.5rem 1rem;
        }

        /* ── Card ── */
        .auth-card {
            display: grid;
            grid-template-columns: 420px 1fr;
            width: 100%;
            max-width: 980px;
            border-radius: 24px;
            overflow: hidden;
            box-shadow: 0 24px 64px rgba(26,39,68,.18), 0 4px 16px rgba(26,39,68,.08);
        }

        /* ── Left Panel ── */
        .auth-left {
            background: linear-gradient(145deg, #1a2744 0%, #253460 50%, #1a2744 100%);
            padding: 3rem 2.5rem;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            position: relative;
            overflow: hidden;
        }
        .auth-left::before {
            content: '';
            position: absolute;
            width: 340px; height: 340px; border-radius: 50%;
            background: rgba(232,135,42,.12);
            top: -80px; right: -80px;
        }
        .auth-left::after {
            content: '';
            position: absolute;
            width: 200px; height: 200px; border-radius: 50%;
            background: rgba(232,135,42,.08);
            bottom: -40px; left: -40px;
        }

        .brand { position: relative; z-index: 1; }
        .brand-logo {
            font-family: 'Playfair Display', serif;
            font-size: 2rem; font-weight: 700;
            color: #fff; text-decoration: none; letter-spacing: -.3px;
        }
        .brand-logo span { color: var(--saffron); }
        .brand-tagline { color: rgba(255,255,255,.45); font-size: .82rem; margin-top: .3rem; }

        .left-content { position: relative; z-index: 1; }
        .left-headline {
            font-family: 'Playfair Display', serif;
            font-size: 1.7rem; font-weight: 700; color: #fff;
            line-height: 1.25; margin-bottom: 1rem;
        }
        .left-headline span { color: var(--saffron); }
        .left-sub { color: rgba(255,255,255,.5); font-size: .88rem; line-height: 1.6; margin-bottom: 2rem; }

        /* Steps */
        .steps { display: flex; flex-direction: column; gap: .9rem; }
        .step {
            display: flex; align-items: flex-start; gap: .9rem;
        }
        .step-num {
            width: 28px; height: 28px; border-radius: 50%;
            background: rgba(232,135,42,.2); border: 1.5px solid rgba(232,135,42,.4);
            color: var(--saffron); font-size: .75rem; font-weight: 700;
            display: flex; align-items: center; justify-content: center; flex-shrink: 0;
            margin-top: .05rem;
        }
        .step-text strong { display: block; color: rgba(255,255,255,.85); font-size: .85rem; margin-bottom: .1rem; }
        .step-text span   { color: rgba(255,255,255,.4); font-size: .78rem; }

        .left-footer { position: relative; z-index: 1; color: rgba(255,255,255,.3); font-size: .75rem; }

        /* ── Right Panel ── */
        .auth-right {
            background: var(--white);
            padding: 2.5rem 2.8rem;
            overflow-y: auto;
        }

        .auth-title {
            font-family: 'Playfair Display', serif;
            font-size: 1.6rem; font-weight: 700; color: var(--navy); margin-bottom: .3rem;
        }
        .auth-subtitle { color: var(--text-soft); font-size: .88rem; margin-bottom: 1.8rem; }
        .auth-subtitle a { color: var(--saffron); text-decoration: none; font-weight: 600; }
        .auth-subtitle a:hover { text-decoration: underline; }

        /* ── Alert ── */
        .alert {
            padding: .75rem 1rem; border-radius: 10px;
            font-size: .85rem; font-weight: 500;
            display: flex; align-items: center; gap: .6rem;
            margin-bottom: 1.3rem;
        }
        .alert-error   { background: #fff5f5; color: var(--error);   border: 1px solid #fed7d7; }
        .alert-success { background: #f0fff4; color: var(--success); border: 1px solid #9ae6b4; }

        /* ── Section Label ── */
        .section-label {
            font-size: .72rem; font-weight: 700; text-transform: uppercase;
            letter-spacing: .8px; color: var(--saffron);
            border-bottom: 1.5px solid rgba(232,135,42,.2);
            padding-bottom: .4rem; margin-bottom: 1rem; margin-top: 1.4rem;
        }
        .section-label:first-of-type { margin-top: 0; }

        /* ── Form Row ── */
        .form-row {
            display: grid; grid-template-columns: 1fr 1fr; gap: 1rem;
        }
        .form-group { margin-bottom: 1rem; }

        .form-label {
            display: block; font-size: .78rem; font-weight: 600;
            color: var(--navy); text-transform: uppercase;
            letter-spacing: .4px; margin-bottom: .45rem;
        }
        .required-star { color: var(--saffron); margin-left: .2rem; }

        .input-wrap { position: relative; }
        .input-icon {
            position: absolute; left: 1rem; top: 50%;
            transform: translateY(-50%);
            color: var(--text-soft); font-size: .82rem;
            pointer-events: none; transition: color .2s;
        }
        .input-wrap input,
        .input-wrap textarea {
            width: 100%;
            padding: .7rem 1rem .7rem 2.6rem;
            border: 1.5px solid var(--border); border-radius: 10px;
            font-family: 'DM Sans', sans-serif; font-size: .9rem;
            color: var(--navy); background: var(--ivory);
            outline: none;
            transition: border-color .2s, box-shadow .2s, background .2s;
        }
        .input-wrap input:focus,
        .input-wrap textarea:focus {
            border-color: var(--navy); background: var(--white);
            box-shadow: 0 0 0 3px rgba(26,39,68,.08);
        }
        .input-wrap:focus-within .input-icon { color: var(--navy); }

        /* valid / invalid states */
        .input-wrap input.valid   { border-color: var(--success); }
        .input-wrap input.invalid { border-color: var(--error); }

        .input-hint {
            font-size: .75rem; color: var(--text-soft);
            margin-top: .3rem; display: block;
        }
        .input-hint.err { color: var(--error); }

        /* password toggle */
        .toggle-pw {
            position: absolute; right: .9rem; top: 50%;
            transform: translateY(-50%);
            background: none; border: none; cursor: pointer;
            color: var(--text-soft); font-size: .82rem; padding: .2rem;
            transition: color .2s;
        }
        .toggle-pw:hover { color: var(--navy); }

        /* textarea override */
        .input-wrap textarea {
            padding-top: .7rem; resize: none; height: 72px;
        }

        /* ── Password Strength ── */
        .strength-bar {
            display: flex; gap: 4px; margin-top: .4rem;
        }
        .strength-segment {
            flex: 1; height: 3px; border-radius: 2px;
            background: var(--border); transition: background .3s;
        }
        .strength-label {
            font-size: .72rem; color: var(--text-soft);
            margin-top: .25rem; font-weight: 600;
        }

        /* ── Submit Button ── */
        .btn-register {
            width: 100%; padding: .85rem;
            background: linear-gradient(135deg, var(--navy) 0%, var(--navy-mid) 100%);
            color: #fff; border: none; border-radius: 10px;
            font-family: 'DM Sans', sans-serif;
            font-size: .95rem; font-weight: 600; cursor: pointer;
            display: flex; align-items: center; justify-content: center; gap: .6rem;
            transition: transform .2s, box-shadow .2s, background .2s;
            margin-top: 1.5rem; letter-spacing: .2px;
        }
        .btn-register:hover {
            background: linear-gradient(135deg, var(--navy-mid) 0%, var(--saffron) 100%);
            transform: translateY(-2px);
            box-shadow: 0 8px 24px rgba(26,39,68,.25);
        }
        .btn-register:active { transform: translateY(0); }
        .btn-register:disabled {
            opacity: .6; cursor: not-allowed; transform: none;
        }

        /* ── Terms note ── */
        .terms-note {
            text-align: center; font-size: .78rem;
            color: var(--text-soft); margin-top: .9rem; line-height: 1.5;
        }
        .terms-note a { color: var(--saffron); text-decoration: none; font-weight: 600; }

        /* ── Login Prompt ── */
        .login-prompt {
            margin-top: 1.2rem; text-align: center;
            font-size: .85rem; color: var(--text-soft);
        }
        .login-prompt a { color: var(--navy); font-weight: 700; text-decoration: none; }
        .login-prompt a:hover { color: var(--saffron); }

        /* ── Responsive ── */
        @media (max-width: 750px) {
            .auth-card { grid-template-columns: 1fr; max-width: 480px; }
            .auth-left  { display: none; }
            .auth-right { padding: 2.2rem 1.5rem; }
            .form-row   { grid-template-columns: 1fr; }
        }
    </style>
</head>
<body>

<div class="auth-card">

    <!-- ══ LEFT PANEL ══ -->
    <div class="auth-left">
        <div class="brand">
            <a href="${pageContext.request.contextPath}/products" class="brand-logo">
                Shop<span>Ease</span>
            </a>
            <div class="brand-tagline">Your trusted online store</div>
        </div>

        <div class="left-content">
            <div class="left-headline">
                Join <span>ShopEase</span><br>today for free
            </div>
            <div class="left-sub">
                Create your account in seconds and start shopping<br>
                from thousands of products across all categories.
            </div>
            <div class="steps">
                <div class="step">
                    <div class="step-num">1</div>
                    <div class="step-text">
                        <strong>Fill in your details</strong>
                        <span>Name, email and a secure password</span>
                    </div>
                </div>
                <div class="step">
                    <div class="step-num">2</div>
                    <div class="step-text">
                        <strong>Add your address</strong>
                        <span>For faster checkout every time</span>
                    </div>
                </div>
                <div class="step">
                    <div class="step-num">3</div>
                    <div class="step-text">
                        <strong>Start shopping!</strong>
                        <span>Browse, add to cart and order instantly</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="left-footer">
            &copy; 2025 ShopEase &mdash; Designed by Devendra Mali
        </div>
    </div>

    <!-- ══ RIGHT PANEL ══ -->
    <div class="auth-right">

        <div class="auth-title">Create Account</div>
        <div class="auth-subtitle">
            Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a>
        </div>

        <%-- Messages --%>
        <c:if test="${not empty error}">
            <div class="alert alert-error">
                <i class="fas fa-exclamation-circle"></i> ${error}
            </div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert alert-success">
                <i class="fas fa-check-circle"></i> ${success}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post" id="registerForm" novalidate>

            <!-- ── Account Info ── -->
            <div class="section-label"><i class="fas fa-user-circle"></i> &nbsp;Account Info</div>

            <div class="form-row">
                <div class="form-group">
                    <label class="form-label">Username <span class="required-star">*</span></label>
                    <div class="input-wrap">
                        <input type="text" name="username" id="username"
                              
                               value="${param.username}"
                               required minlength="3" maxlength="30"
                               autocomplete="username"
                               oninput="validateUsername(this)">
                        <i class="fas fa-at input-icon"></i>
                    </div>
                    <span class="input-hint" id="usernameHint">Min 3 characters, no spaces</span>
                </div>
                <div class="form-group">
                    <label class="form-label">Full Name <span class="required-star">*</span></label>
                    <div class="input-wrap">
                        <input type="text" name="fullName" id="fullName"
                               
                               value="${param.fullName}"
                               required maxlength="100"
                               oninput="validateNotEmpty(this, 'fullNameHint', 'Enter your full name')">
                        <i class="fas fa-user input-icon"></i>
                    </div>
                    <span class="input-hint" id="fullNameHint"></span>
                </div>
            </div>

            <div class="form-group">
                <label class="form-label">Email Address <span class="required-star">*</span></label>
                <div class="input-wrap">
                    <input type="email" name="email" id="email"
                           
                           value="${param.email}"
                           required autocomplete="email"
                           oninput="validateEmail(this)">
                    <i class="fas fa-envelope input-icon"></i>
                </div>
                <span class="input-hint" id="emailHint"></span>
            </div>

            <!-- ── Password ── -->
            <div class="section-label"><i class="fas fa-lock"></i> &nbsp;Password</div>

            <div class="form-row">
                <div class="form-group">
                    <label class="form-label">Password <span class="required-star">*</span></label>
                    <div class="input-wrap">
                        <input type="password" name="password" id="password"
                               placeholder="Min 6 characters"
                               required minlength="6"
                               autocomplete="new-password"
                               oninput="checkStrength(this.value); validateConfirm()">
                        <i class="fas fa-lock input-icon"></i>
                        <button type="button" class="toggle-pw" onclick="togglePw('password','eye1')" title="Show/hide">
                            <i class="fas fa-eye" id="eye1"></i>
                        </button>
                    </div>
                    <div class="strength-bar">
                        <div class="strength-segment" id="s1"></div>
                        <div class="strength-segment" id="s2"></div>
                        <div class="strength-segment" id="s3"></div>
                        <div class="strength-segment" id="s4"></div>
                    </div>
                    <span class="strength-label" id="strengthLabel"></span>
                </div>
                <div class="form-group">
                    <label class="form-label">Confirm Password <span class="required-star">*</span></label>
                    <div class="input-wrap">
                        <input type="password" name="confirmPassword" id="confirmPassword"
                               placeholder="Repeat password"
                               required autocomplete="new-password"
                               oninput="validateConfirm()">
                        <i class="fas fa-lock input-icon"></i>
                        <button type="button" class="toggle-pw" onclick="togglePw('confirmPassword','eye2')" title="Show/hide">
                            <i class="fas fa-eye" id="eye2"></i>
                        </button>
                    </div>
                    <span class="input-hint" id="confirmHint"></span>
                </div>
            </div>

            <!-- ── Contact Info ── -->
            <div class="section-label"><i class="fas fa-address-card"></i> &nbsp;Contact Info</div>

            <div class="form-group">
                <label class="form-label">Phone Number</label>
                <div class="input-wrap">
                    <input type="tel" name="phone" id="phone"
                           
                           value="${param.phone}"
                           maxlength="15">
                    <i class="fas fa-phone input-icon"></i>
                </div>
            </div>

            <div class="form-group">
                <label class="form-label">Delivery Address</label>
                <div class="input-wrap">
                    <textarea name="address" id="address"
                              placeholder="House No, Street, Area, City, State, PIN Code">${param.address}</textarea>
                    <i class="fas fa-map-marker-alt input-icon" style="top:1rem;transform:none"></i>
                </div>
                <span class="input-hint">Used as default shipping address at checkout</span>
            </div>

            <button type="submit" class="btn-register" id="submitBtn">
                <i class="fas fa-user-plus"></i> Create My Account
            </button>

            <div class="terms-note">
                By registering you agree to our
                <a href="#">Terms of Service</a> and <a href="#">Privacy Policy</a>
            </div>

        </form>

        <div class="login-prompt">
            Already have an account?
            <a href="${pageContext.request.contextPath}/login">Sign in &rarr;</a>
        </div>

    </div>
</div>

<script>
/* ── Toggle password visibility ── */
function togglePw(fieldId, iconId) {
    const field = document.getElementById(fieldId);
    const icon  = document.getElementById(iconId);
    if (field.type === 'password') {
        field.type = 'text';
        icon.classList.replace('fa-eye', 'fa-eye-slash');
    } else {
        field.type = 'password';
        icon.classList.replace('fa-eye-slash', 'fa-eye');
    }
}

/* ── Username validation ── */
function validateUsername(input) {
    const hint = document.getElementById('usernameHint');
    const val  = input.value.trim();
    if (val.length === 0) {
        setNeutral(input, hint, 'Min 3 characters, no spaces');
    } else if (val.length < 3 || /\s/.test(val)) {
        setInvalid(input, hint, 'Min 3 characters, no spaces allowed');
    } else {
        setValid(input, hint, '✓ Looks good');
    }
}

/* ── Email validation ── */
function validateEmail(input) {
    const hint  = document.getElementById('emailHint');
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (input.value === '') {
        setNeutral(input, hint, '');
    } else if (!regex.test(input.value)) {
        setInvalid(input, hint, 'Enter a valid email address');
    } else {
        setValid(input, hint, '✓ Valid email');
    }
}

/* ── Generic not-empty ── */
function validateNotEmpty(input, hintId, errMsg) {
    const hint = document.getElementById(hintId);
    if (input.value.trim() === '') {
        setInvalid(input, hint, errMsg);
    } else {
        setValid(input, hint, '✓ Looks good');
    }
}

/* ── Password strength ── */
function checkStrength(val) {
    const segs   = [document.getElementById('s1'), document.getElementById('s2'),
                    document.getElementById('s3'), document.getElementById('s4')];
    const label  = document.getElementById('strengthLabel');
    const colors = ['#e53e3e','#e8872a','#d69e2e','#2d7a4f'];
    const labels = ['Weak','Fair','Good','Strong'];

    let score = 0;
    if (val.length >= 6)  score++;
    if (val.length >= 10) score++;
    if (/[A-Z]/.test(val) && /[0-9]/.test(val)) score++;
    if (/[^A-Za-z0-9]/.test(val)) score++;

    segs.forEach((s, i) => {
        s.style.background = i < score ? colors[score - 1] : 'var(--border)';
    });
    label.textContent  = val.length > 0 ? labels[score - 1] || '' : '';
    label.style.color  = score > 0 ? colors[score - 1] : 'var(--text-soft)';
}

/* ── Confirm password ── */
function validateConfirm() {
    const pw      = document.getElementById('password').value;
    const confirm = document.getElementById('confirmPassword');
    const hint    = document.getElementById('confirmHint');
    if (confirm.value === '') {
        setNeutral(confirm, hint, '');
    } else if (confirm.value !== pw) {
        setInvalid(confirm, hint, 'Passwords do not match');
    } else {
        setValid(confirm, hint, '✓ Passwords match');
    }
}

/* ── Helpers ── */
function setValid(input, hint, msg) {
    input.classList.remove('invalid'); input.classList.add('valid');
    hint.textContent = msg; hint.classList.remove('err');
    hint.style.color = 'var(--success)';
}
function setInvalid(input, hint, msg) {
    input.classList.remove('valid'); input.classList.add('invalid');
    hint.textContent = msg; hint.classList.add('err');
    hint.style.color = 'var(--error)';
}
function setNeutral(input, hint, msg) {
    input.classList.remove('valid','invalid');
    hint.textContent = msg; hint.classList.remove('err');
    hint.style.color = 'var(--text-soft)';
}

/* ── Prevent submit if passwords don't match ── */
document.getElementById('registerForm').addEventListener('submit', function(e) {
    const pw      = document.getElementById('password').value;
    const confirm = document.getElementById('confirmPassword').value;
    if (pw !== confirm) {
        e.preventDefault();
        setInvalid(document.getElementById('confirmPassword'),
                   document.getElementById('confirmHint'),
                   'Passwords do not match');
        document.getElementById('confirmPassword').focus();
    }
});
</script>

</body>
</html>
