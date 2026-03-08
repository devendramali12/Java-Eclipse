<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login — ShopEase</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600;700&family=DM+Sans:wght@300;400;500;600&display=swap"
rel="stylesheet">

</head>

<body class="auth-page">

<div class="auth-container">

<div class="auth-card" style="max-width:420px;margin:auto;padding:2rem;">

<div class="auth-logo">
Shop<span>Ease</span>
</div>

<div class="auth-divider"></div>

<h2 style="margin-bottom:.3rem">Welcome Back</h2>

<p class="auth-subtitle" style="margin-bottom:1.4rem">
Sign in to continue shopping
</p>


<!-- ERROR -->

<c:if test="${not empty error}">
<div class="alert alert-error">
<i class="fas fa-exclamation-circle"></i>
<c:out value="${error}" />
</div>
</c:if>


<!-- SUCCESS -->

<c:if test="${not empty success}">
<div class="alert alert-success">
<i class="fas fa-check-circle"></i>
<c:out value="${success}" />
</div>
</c:if>



<form action="${pageContext.request.contextPath}/login"
method="post"
id="loginForm">

<div class="form-group">

<label for="username">
<i class="fas fa-user"></i> Username
</label>

<input
type="text"
id="username"
name="username"
placeholder="Enter your username"
required
autocomplete="username">

</div>



<div class="form-group">

<label for="password">
<i class="fas fa-lock"></i> Password
</label>

<div style="position:relative">

<input
type="password"
id="password"
name="password"
placeholder="Enter your password"
required
autocomplete="current-password">

<i class="fas fa-eye"
id="togglePassword"
style="position:absolute;right:12px;top:50%;transform:translateY(-50%);cursor:pointer;color:#888"></i>

</div>

</div>



<button type="submit"
class="btn-primary full-width"
id="loginBtn"
style="margin-top:.8rem">

<i class="fas fa-sign-in-alt"></i> Sign In

</button>

</form>



<p class="auth-footer" style="margin-top:1.2rem">

New to ShopEase?

<a href="${pageContext.request.contextPath}/register">
Create an account
</a>

</p>

</div>

</div>



<script>

/* PASSWORD TOGGLE */

const togglePassword = document.getElementById("togglePassword")
const password = document.getElementById("password")

togglePassword.addEventListener("click", () => {

const type = password.type === "password" ? "text" : "password"
password.type = type

togglePassword.classList.toggle("fa-eye")
togglePassword.classList.toggle("fa-eye-slash")

})


/* BUTTON LOADING */

document.getElementById("loginForm").addEventListener("submit", function(){

const btn = document.getElementById("loginBtn")

btn.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Signing In...'
btn.disabled = true

})

</script>

</body>
</html>