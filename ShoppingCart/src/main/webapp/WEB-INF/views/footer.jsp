<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<footer class="footer">

<div class="footer-container">

    <!-- BRAND -->

    <div class="footer-brand">

        <h2 class="footer-logo">
            Shop<span>Ease</span>
        </h2>

        <p class="footer-desc">
            ShopEase is your trusted online marketplace delivering quality
            products with secure payments and fast shipping.
        </p>

        <!-- TRUST BADGES -->

        <div class="trust-badges">

            <span>🔒 Secure Checkout</span>
            <span>🚚 Fast Delivery</span>
            <span>↩ Easy Returns</span>
            <span>⭐ Trusted Store</span>

        </div>

    </div>


    <!-- QUICK LINKS -->

    <div class="footer-section">

        <h3>Quick Links</h3>

        <a href="${pageContext.request.contextPath}/products">Shop</a>
        <a href="${pageContext.request.contextPath}/cart">Cart</a>
        <a href="${pageContext.request.contextPath}/orders">Orders</a>
        <a href="${pageContext.request.contextPath}/profile">Profile</a>

    </div>


    <!-- CUSTOMER SERVICE -->

    <div class="footer-section">

        <h3>Customer Service</h3>

        <a href="#">Help Center</a>
        <a href="#">Return Policy</a>
        <a href="#">Shipping Info</a>
        <a href="#">Contact Support</a>

        <p class="support">📧 support@shopease.com</p>
        <p class="support">📞 +91 98765 43210</p>

    </div>


    <!-- NEWSLETTER -->

    <div class="footer-section">

        <h3>Stay Updated</h3>

        <p class="newsletter-text">
            Subscribe for latest offers and product updates.
        </p>

        <form class="newsletter-form">

            <input type="email" placeholder="Enter your email">

            <button type="submit">
                Subscribe
            </button>

        </form>

        <!-- PAYMENT METHODS -->

        <div class="payments">

            <span>💳 Visa</span>
            <span>💳 Mastercard</span>
            <span>🏦 UPI</span>
            <span>📱 Paytm</span>

        </div>

    </div>

</div>


<!-- FOOTER BOTTOM -->

<div class="footer-bottom">

    <p>
        © <%= java.time.Year.now() %>
        <span class="brand">ShopEase</span>
        — All rights reserved
    </p>

    <p>
        Designed & Developed with ❤ by
        <span class="dev">Devendra Mali</span>
    </p>

</div>

</footer>


<style>

/* FOOTER */

.footer{

background:linear-gradient(135deg,#0f1a35,#091225);

color:rgba(255,255,255,.75);

font-family:'DM Sans',sans-serif;

margin-top:4rem;

border-top:3px solid #ff9933;

}


/* CONTAINER */

.footer-container{

max-width:1300px;

margin:auto;

padding:3rem 2rem;

display:grid;

grid-template-columns:2fr 1fr 1fr 1.5fr;

gap:2rem;

}


/* LOGO */

.footer-logo{

font-size:1.8rem;

font-family:'Playfair Display',serif;

color:white;

}

.footer-logo span{

color:#ff9933;

}

.footer-desc{

font-size:.85rem;

margin:.6rem 0;

color:rgba(255,255,255,.6);

line-height:1.5;

}


/* TRUST BADGES */

.trust-badges{

display:flex;

flex-wrap:wrap;

gap:.4rem;

margin-top:.7rem;

}

.trust-badges span{

background:rgba(255,255,255,.07);

border:1px solid rgba(255,255,255,.15);

padding:.3rem .6rem;

border-radius:20px;

font-size:.75rem;

}


/* SECTIONS */

.footer-section h3{

color:white;

margin-bottom:.6rem;

font-size:1rem;

}

.footer-section a{

display:block;

text-decoration:none;

color:rgba(255,255,255,.7);

font-size:.85rem;

margin:.35rem 0;

transition:.2s;

}

.footer-section a:hover{

color:#ff9933;

transform:translateX(3px);

}


/* SUPPORT */

.support{

font-size:.8rem;

margin-top:.3rem;

}


/* NEWSLETTER */

.newsletter-text{

font-size:.8rem;

margin-bottom:.6rem;

}

.newsletter-form{

display:flex;

gap:.4rem;

}

.newsletter-form input{

flex:1;

padding:.45rem;

border:none;

border-radius:4px;

}

.newsletter-form button{

background:#ff9933;

border:none;

padding:.45rem .8rem;

border-radius:4px;

cursor:pointer;

font-size:.8rem;

}

.newsletter-form button:hover{

background:#ffa733;

}


/* PAYMENTS */

.payments{

margin-top:.7rem;

display:flex;

gap:.5rem;

flex-wrap:wrap;

font-size:.8rem;

opacity:.85;

}


/* BOTTOM */

.footer-bottom{

border-top:1px solid rgba(255,255,255,.1);

margin-top:1.5rem;

padding:1rem 2rem;

max-width:1300px;

margin:auto;

display:flex;

justify-content:space-between;

flex-wrap:wrap;

font-size:.8rem;

}

.brand{

color:#ff9933;

font-weight:600;

}

.dev{

color:#ff9933;

font-weight:700;

}


/* RESPONSIVE */

@media(max-width:900px){

.footer-container{

grid-template-columns:1fr 1fr;

}

}

@media(max-width:600px){

.footer-container{

grid-template-columns:1fr;

text-align:center;

}

.trust-badges{

justify-content:center;

}

.footer-bottom{

flex-direction:column;

text-align:center;

gap:.4rem;

}

}

</style>