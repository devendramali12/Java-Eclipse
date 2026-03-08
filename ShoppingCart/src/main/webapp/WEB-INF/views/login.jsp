<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login — ShopEase</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600;700&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

        :root {
            --navy:    #1a2744;
            --saffron: #e8872a;
            --ivory:   #faf8f4;
            --white:   #ffffff;
            --border:  #e8e0d4;
            --text-soft: #8a7f72;
            --success: #2d7a4f;
            --error:   #c53030;
            --radius:  14px;
        }

        body {
            font-family: 'DM Sans', sans-serif;
            background: var(--ivory);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 1rem;
        }

        /* ── Main Card ── */
        .auth-card {
            display: grid;
            grid-template-columns: 1fr 1fr;
            width: 100%;
            max-width: 920px;
            min-height: 560px;
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
            width: 340px; height: 340px;
            border-radius: 50%;
            background: rgba(232,135,42,.12);
            top: -80px; right: -80px;
        }
        .auth-left::after {
            content: '';
            position: absolute;
            width: 220px; height: 220px;
            border-radius: 50%;
            background: rgba(232,135,42,.08);
            bottom: -50px; left: -50px;
        }

        .brand {
            position: relative; z-index: 1;
        }
        .brand-logo {
            font-family: 'Playfair Display', serif;
            font-size: 2rem;
            font-weight: 700;
            color: #fff;
            text-decoration: none;
            letter-spacing: -.3px;
        }
        .brand-logo span { color: var(--saffron); }
        .brand-tagline {
            color: rgba(255,255,255,.45);
            font-size: .82rem;
            margin-top: .3rem;
            letter-spacing: .3px;
        }

        .left-content {
            position: relative; z-index: 1;
        }
        .left-headline {
            font-family: 'Playfair Display', serif;
            font-size: 1.75rem;
            font-weight: 700;
            color: #fff;
            line-height: 1.25;
            margin-bottom: 1rem;
        }
        .left-headline span {
            color: var(--saffron);
        }
        .left-sub {
            color: rgba(255,255,255,.5);
            font-size: .88rem;
            line-height: 1.6;
            margin-bottom: 2rem;
        }

        .feature-list { list-style: none; }
        .feature-list li {
            display: flex;
            align-items: center;
            gap: .7rem;
            color: rgba(255,255,255,.7);
            font-size: .84rem;
            margin-bottom: .65rem;
        }
        .feature-list li i {
            width: 22px; height: 22px;
            background: rgba(232,135,42,.2);
            border-radius: 50%;
            display: flex; align-items: center; justify-content: center;
            color: var(--saffron);
            font-size: .65rem;
            flex-shrink: 0;
        }

        .left-footer {
            position: relative; z-index: 1;
            color: rgba(255,255,255,.3);
            font-size: .75rem;
        }

        /* ── Right Panel ── */
        .auth-right {
            background: var(--white);
            padding: 3rem 2.8rem;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .auth-title {
            font-family: 'Playfair Display', serif;
            font-size: 1.65rem;
            font-weight: 700;
            color: var(--navy);
            margin-bottom: .3rem;
        }
        .auth-subtitle {
            color: var(--text-soft);
            font-size: .88rem;
            margin-bottom: 2rem;
        }
        .auth-subtitle a {
            color: var(--saffron);
            text-decoration: none;
            font-weight: 600;
        }
        .auth-subtitle a:hover { text-decoration: underline; }

        /* ── Alerts ── */
        .alert {
            padding: .75rem 1rem;
            border-radius: 10px;
            font-size: .85rem;
            font-weight: 500;
            display: flex;
            align-items: center;
            gap: .6rem;
            margin-bottom: 1.3rem;
        }
        .alert-error   { background: #fff5f5; color: var(--error);   border: 1px solid #fed7d7; }
        .alert-success { background: #f0fff4; color: var(--success); border: 1px solid #9ae6b4; }

        /* ── Form ── */
        .form-group { margin-bottom: 1.2rem; }

        .form-label {
            display: block;
            font-size: .8rem;
            font-weight: 600;
            color: var(--navy);
            text-transform: uppercase;
            letter-spacing: .5px;
            margin-bottom: .5rem;
        }

        .input-wrap {
            position: relative;
        }
        .input-icon {
            position: absolute;
            left: 1rem; top: 50%;
            transform: translateY(-50%);
            color: var(--text-soft);
            font-size: .85rem;
            pointer-events: none;
            transition: color .2s;
        }
        .input-wrap input {
            width: 100%;
            padding: .75rem 1rem .75rem 2.75rem;
            border: 1.5px solid var(--border);
            border-radius: 10px;
            font-family: 'DM Sans', sans-serif;
            font-size: .92rem;
            color: var(--navy);
            background: var(--ivory);
            outline: none;
            transition: border-color .2s, box-shadow .2s, background .2s;
        }
        .input-wrap input:focus {
            border-color: var(--navy);
            background: var(--white);
            box-shadow: 0 0 0 3px rgba(26,39,68,.08);
        }
        .input-wrap input:focus + .input-icon,
        .input-wrap:focus-within .input-icon {
            color: var(--navy);
        }

        /* password toggle */
        .toggle-pw {
            position: absolute;
            right: 1rem; top: 50%;
            transform: translateY(-50%);
            background: none; border: none;
            cursor: pointer; color: var(--text-soft);
            font-size: .85rem; padding: .2rem;
            transition: color .2s;
        }
        .toggle-pw:hover { color: var(--navy); }

        /* ── Options row ── */
        .form-options {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1.5rem;
            font-size: .83rem;
        }
        .remember-me {
            display: flex; align-items: center; gap: .5rem;
            color: var(--text-soft); cursor: pointer;
        }
        .remember-me input[type="checkbox"] {
            width: 15px; height: 15px;
            accent-color: var(--navy);
            cursor: pointer;
        }
        .forgot-link {
            color: var(--saffron);
            text-decoration: none;
            font-weight: 600;
        }
        .forgot-link:hover { text-decoration: underline; }

        /* ── Submit Button ── */
        .btn-login {
            width: 100%;
            padding: .85rem;
            background: linear-gradient(135deg, var(--navy) 0%, #253460 100%);
            color: #fff;
            border: none;
            border-radius: 10px;
            font-family: 'DM Sans', sans-serif;
            font-size: .95rem;
            font-weight: 600;
            cursor: pointer;
            display: flex; align-items: center; justify-content: center; gap: .6rem;
            transition: transform .2s, box-shadow .2s, background .2s;
            letter-spacing: .2px;
        }
        .btn-login:hover {
            background: linear-gradient(135deg, #253460 0%, var(--saffron) 100%);
            transform: translateY(-2px);
            box-shadow: 0 8px 24px rgba(26,39,68,.25);
        }
        .btn-login:active { transform: translateY(0); }

        /* ── Divider ── */
        .divider {
            display: flex; align-items: center; gap: .8rem;
            margin: 1.3rem 0;
            color: var(--text-soft); font-size: .78rem;
        }
        .divider::before, .divider::after {
            content: ''; flex: 1;
            height: 1px; background: var(--border);
        }

        /* ── Demo Accounts ── */
        .demo-accounts {
            display: grid; grid-template-columns: 1fr 1fr;
            gap: .5rem;
        }
        .demo-btn {
            padding: .6rem .8rem;
            background: var(--ivory);
            border: 1.5px solid var(--border);
            border-radius: 8px;
            cursor: pointer;
            font-family: 'DM Sans', sans-serif;
            font-size: .78rem;
            color: var(--navy);
            text-align: left;
            transition: border-color .2s, background .2s, transform .15s;
            display: flex; align-items: center; gap: .5rem;
        }
        .demo-btn:hover {
            border-color: var(--navy);
            background: var(--white);
            transform: translateY(-1px);
        }
        .demo-btn .demo-role {
            font-size: .68rem;
            font-weight: 700;
            padding: .1rem .4rem;
            border-radius: 50px;
            letter-spacing: .3px;
        }
        .role-admin    { background: rgba(232,135,42,.15); color: var(--saffron); }
        .role-customer { background: rgba(26,39,68,.1);    color: var(--navy); }

        /* ── Register Link ── */
        .register-prompt {
            margin-top: 1.5rem;
            text-align: center;
            font-size: .85rem;
            color: var(--text-soft);
        }
        .register-prompt a {
            color: var(--navy);
            font-weight: 700;
            text-decoration: none;
        }
        .register-prompt a:hover { color: var(--saffron); }

        /* ── Responsive ── */
        @media (max-width: 680px) {
            .auth-card { grid-template-columns: 1fr; max-width: 440px; }
            .auth-left  { display: none; }
            .auth-right { padding: 2.5rem 2rem; }
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
                Welcome<br>back to <span>ShopEase</span>
            </div>
            <div class="left-sub">
                Sign in to access your account, track orders,<br>
                and discover thousands of products.
            </div>
            <ul class="feature-list">
                <li><i class="fas fa-check"></i> Free delivery on orders over ₹999</li>
                <li><i class="fas fa-check"></i> Easy 7-day returns</li>
                <li><i class="fas fa-check"></i> Exclusive member discounts</li>
                <li><i class="fas fa-check"></i> Real-time order tracking</li>
            </ul>
        </div>

        <div class="left-footer">
            &copy; 2025 ShopEase &mdash; Designed by Devendra Mali
        </div>
    </div>

    <!-- ══ RIGHT PANEL ══ -->
    <div class="auth-right">

        <div class="auth-title">Sign In</div>
        <div class="auth-subtitle">
            New here? <a href="${pageContext.request.contextPath}/register">Create an account</a>
        </div>

        <%-- Error / Success Messages --%>
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
        <c:if test="${param.registered == 'true'}">
            <div class="alert alert-success">
                <i class="fas fa-check-circle"></i> Account created! Please sign in.
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post" id="loginForm">

            <div class="form-group">
                <label class="form-label">Username</label>
                <div class="input-wrap">
                    <input type="text" name="username" id="username"
                           placeholder="Enter your username"
                           value="${param.username}" required autocomplete="username">
                    <i class="fas fa-user input-icon"></i>
                </div>
            </div>

            <div class="form-group">
                <label class="form-label">Password</label>
                <div class="input-wrap">
                    <input type="password" name="password" id="password"
                           placeholder="Enter your password"
                           required autocomplete="current-password">
                    <i class="fas fa-lock input-icon"></i>
                    <button type="button" class="toggle-pw" onclick="togglePassword()" title="Show/Hide password">
                        <i class="fas fa-eye" id="eyeIcon"></i>
                    </button>
                </div>
            </div>

            <div class="form-options">
                <label class="remember-me">
                    <input type="checkbox" name="remember"> Remember me
                </label>
                <a href="#" class="forgot-link">Forgot password?</a>
            </div>

            <button type="submit" class="btn-login">
                <i class="fas fa-sign-in-alt"></i> Sign In to ShopEase
            </button>

        </form>

  

        

        <div class="register-prompt">
            Don't have an account?
            <a href="${pageContext.request.contextPath}/register">Register now &rarr;</a>
        </div>

    </div>
</div>

<script>
function togglePassword() {
    const pw  = document.getElementById('password');
    const eye = document.getElementById('eyeIcon');
    if (pw.type === 'password') {
        pw.type = 'text';
        eye.classList.replace('fa-eye', 'fa-eye-slash');
    } else {
        pw.type = 'password';
        eye.classList.replace('fa-eye-slash', 'fa-eye');
    }
}

function fillDemo(user, pass) {
    document.getElementById('username').value = user;
    document.getElementById('password').value = pass;
    document.getElementById('loginForm').submit();
}
</script>

</body>
</html>
