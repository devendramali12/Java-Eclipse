<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<footer class="footer">

    <div class="footer-container">

        <!-- BRAND -->
        <div class="footer-brand">
            <h2 class="footer-logo">
                Shop<span>Ease</span>
            </h2>
            <p class="footer-tagline">
                Your trusted online shopping destination
            </p>
        </div>

        <!-- LINKS -->
        <nav class="footer-links" aria-label="Footer Navigation">
            <a href="${pageContext.request.contextPath}/products">🛍️ Shop</a>
            <a href="${pageContext.request.contextPath}/cart">🛒 Cart</a>
            <a href="${pageContext.request.contextPath}/orders">📦 Orders</a>
            <a href="${pageContext.request.contextPath}/profile">👤 Profile</a>
        </nav>

        <!-- TECHNOLOGIES -->
        <div class="footer-tech">
            <span class="tech-badge">☕ Java Servlet</span>
            <span class="tech-badge">📄 JSP</span>
            <span class="tech-badge">🐘 PostgreSQL</span>
            <span class="tech-badge">🐱 Tomcat 11</span>
        </div>

    </div>

    <!-- FOOTER BOTTOM -->

    <div class="footer-bottom">

        <p>
            &copy; <%= java.time.Year.now() %>
            <span class="brand-name">ShopEase</span>
            — All rights reserved.
        </p>

        <p class="footer-credit">
            Designed & Developed with
            <span class="heart">❤</span>
            by
            <span class="dev-name">Devendra Mali</span>
        </p>

    </div>

</footer>

<style>

.footer{
    background: linear-gradient(135deg,var(--navy),#0f1a35);
    color: rgba(255,255,255,.65);
    margin-top:4rem;
    border-top:3px solid var(--saffron);
    font-family:'DM Sans',sans-serif;
}

.footer-container{
    max-width:1280px;
    margin:auto;
    padding:2.5rem 2rem;
    display:grid;
    grid-template-columns:1.5fr 1fr 1.5fr;
    gap:2rem;
    align-items:center;
}

/* LOGO */

.footer-logo{
    font-family:'Playfair Display',serif;
    font-size:1.7rem;
    font-weight:700;
    color:#fff;
}

.footer-logo span{
    color:var(--saffron);
}

.footer-tagline{
    font-size:.85rem;
    color:rgba(255,255,255,.45);
    margin-top:.3rem;
}

/* LINKS */

.footer-links{
    display:flex;
    flex-direction:column;
    gap:.6rem;
    align-items:center;
}

.footer-links a{
    text-decoration:none;
    font-size:.85rem;
    color:rgba(255,255,255,.65);
    transition:.2s;
}

.footer-links a:hover{
    color:var(--saffron);
    transform:translateX(2px);
}

/* TECH BADGES */

.footer-tech{
    display:flex;
    flex-wrap:wrap;
    gap:.5rem;
    justify-content:flex-end;
}

.tech-badge{
    background:rgba(255,255,255,.07);
    border:1px solid rgba(255,255,255,.12);
    padding:.35rem .8rem;
    border-radius:50px;
    font-size:.75rem;
    transition:.2s;
}

.tech-badge:hover{
    background:rgba(232,135,42,.2);
    border-color:var(--saffron);
    color:var(--saffron);
}

/* BOTTOM */

.footer-bottom{
    border-top:1px solid rgba(255,255,255,.08);
    padding:1.2rem 2rem;
    max-width:1280px;
    margin:auto;
    display:flex;
    justify-content:space-between;
    align-items:center;
    font-size:.8rem;
    flex-wrap:wrap;
    gap:.5rem;
}

.brand-name{
    color:var(--saffron);
    font-weight:600;
}

.footer-credit{
    display:flex;
    align-items:center;
    gap:.35rem;
}

/* HEART ANIMATION */

.heart{
    color:#e53e3e;
    animation:heartbeat 1.5s infinite;
}

@keyframes heartbeat{

0%,100%{transform:scale(1)}
25%{transform:scale(1.2)}
50%{transform:scale(1)}
75%{transform:scale(1.1)}

}

/* DEV NAME */

.dev-name{
    font-weight:700;
    background:linear-gradient(90deg,var(--saffron),#f5c76e);
    -webkit-background-clip:text;
    -webkit-text-fill-color:transparent;
}

/* RESPONSIVE */

@media(max-width:768px){

.footer-container{
    grid-template-columns:1fr;
    text-align:center;
}

.footer-links{
    flex-direction:row;
    flex-wrap:wrap;
    justify-content:center;
}

.footer-tech{
    justify-content:center;
}

.footer-bottom{
    flex-direction:column;
    text-align:center;
}

}

</style>