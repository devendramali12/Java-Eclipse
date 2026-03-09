/**
 * script.js - WanderLux Travel Tourism System
 * Location  : src/main/webapp/js/script.js
 *
 * Written in ES5-compatible JavaScript to avoid
 * Eclipse IDE JavaScript validator warnings.
 */

// ── Navbar Scroll Effect ──────────────────────────────────────────────────
window.addEventListener('scroll', function () {
    var navbar = document.querySelector('.navbar');
    if (navbar) {
        if (window.scrollY > 40) {
            navbar.classList.add('scrolled');
        } else {
            navbar.classList.remove('scrolled');
        }
    }
});

// ── Login Form Validation ─────────────────────────────────────────────────
function validateLoginForm() {
    var emailEl    = document.getElementById('email');
    var passwordEl = document.getElementById('password');
    var email      = emailEl    ? emailEl.value.trim()    : '';
    var password   = passwordEl ? passwordEl.value.trim() : '';

    if (!email || !password) {
        showFormError('Please fill in all fields.');
        return false;
    }
    if (!isValidEmail(email)) {
        showFormError('Please enter a valid email address.');
        return false;
    }
    return true;
}

// ── Register Form Validation ──────────────────────────────────────────────
function validateRegisterForm() {
    var nameEl     = document.getElementById('name');
    var emailEl    = document.getElementById('email');
    var passwordEl = document.getElementById('password');
    var phoneEl    = document.getElementById('phone');

    var name     = nameEl     ? nameEl.value.trim()     : '';
    var email    = emailEl    ? emailEl.value.trim()    : '';
    var password = passwordEl ? passwordEl.value.trim() : '';
    var phone    = phoneEl    ? phoneEl.value.trim()    : '';

    if (!name || !email || !password) {
        showFormError('Name, email and password are required.');
        return false;
    }
    if (!isValidEmail(email)) {
        showFormError('Please enter a valid email address.');
        return false;
    }
    if (password.length < 6) {
        showFormError('Password must be at least 6 characters.');
        return false;
    }
    if (phone && !/^\+?[\d\s\-()]{7,15}$/.test(phone)) {
        showFormError('Please enter a valid phone number.');
        return false;
    }
    return true;
}

// ── Booking Form Validation ───────────────────────────────────────────────
function validateBookingForm() {
    var dateEl   = document.getElementById('travelDate');
    var peopleEl = document.getElementById('people');

    var dateVal  = dateEl   ? dateEl.value   : '';
    var people   = peopleEl ? parseInt(peopleEl.value) : NaN;

    if (!dateVal) {
        showFormError('Please select a travel date.');
        return false;
    }

    var today = new Date();
    today.setHours(0, 0, 0, 0);
    var selectedDate = new Date(dateVal);

    if (selectedDate <= today) {
        showFormError('Travel date must be a future date.');
        return false;
    }
    if (isNaN(people) || people < 1 || people > 20) {
        showFormError('Number of travellers must be between 1 and 20.');
        return false;
    }
    return true;
}

// ── Package Form Validation (Admin) ──────────────────────────────────────
function validatePackageForm() {
    var nameEl     = document.getElementById('packageName');
    var locationEl = document.getElementById('location');
    var priceEl    = document.getElementById('price');

    var name     = nameEl     ? nameEl.value.trim()     : '';
    var location = locationEl ? locationEl.value.trim() : '';
    var price    = priceEl    ? parseFloat(priceEl.value) : NaN;

    if (!name || !location) {
        showFormError('Package name and location are required.');
        return false;
    }
    if (isNaN(price) || price <= 0) {
        showFormError('Please enter a valid positive price.');
        return false;
    }
    return true;
}

// ── Live Total Price Calculator ───────────────────────────────────────────
function updateTotalPrice() {
    var priceEl  = document.getElementById('packagePrice');
    var peopleEl = document.getElementById('people');
    var totalEl  = document.getElementById('totalPrice');

    if (!priceEl || !peopleEl || !totalEl) { return; }

    var price  = parseFloat(priceEl.getAttribute('data-price') || '0');
    var people = parseInt(peopleEl.value) || 1;
    var total  = price * people;

    totalEl.textContent = '\u20B9' + total.toLocaleString('en-IN');
}

// ── Live Package Search ───────────────────────────────────────────────────
function initSearch() {
    var searchInput = document.getElementById('searchInput');
    var cards       = document.querySelectorAll('.package-card');

    if (!searchInput || !cards.length) { return; }

    searchInput.addEventListener('input', function () {
        var query = searchInput.value.toLowerCase().trim();

        for (var i = 0; i < cards.length; i++) {
            var card     = cards[i];
            var titleEl  = card.querySelector('.card-title');
            var locEl    = card.querySelector('.card-location');
            var title    = titleEl ? titleEl.textContent.toLowerCase() : '';
            var location = locEl   ? locEl.textContent.toLowerCase()   : '';
            var match    = !query || title.indexOf(query) !== -1 || location.indexOf(query) !== -1;
            card.style.display = match ? '' : 'none';
        }

        // Show/hide "no results" message
        var emptyMsg = document.getElementById('noResults');
        if (emptyMsg) {
            var visible = 0;
            for (var j = 0; j < cards.length; j++) {
                if (cards[j].style.display !== 'none') { visible++; }
            }
            emptyMsg.style.display = visible === 0 ? 'block' : 'none';
        }
    });
}

// ── Open Edit Package Modal (Admin) ──────────────────────────────────────
function openEditModal(id, name, location, price, duration, description, imageUrl) {
    var modal = document.getElementById('editModal');
    if (!modal) { return; }

    document.getElementById('editPackageId').value  = id;
    document.getElementById('editName').value        = name;
    document.getElementById('editLocation').value    = location;
    document.getElementById('editPrice').value       = price;
    document.getElementById('editDuration').value    = duration;
    document.getElementById('editDescription').value = description;
    document.getElementById('editImageUrl').value    = imageUrl || '';

    modal.style.display = 'flex';
}

// ── Close Modal ───────────────────────────────────────────────────────────
function closeModal(modalId) {
    var modal = document.getElementById(modalId);
    if (modal) { modal.style.display = 'none'; }
}

// Close modal when clicking the dark backdrop
document.addEventListener('click', function (e) {
    if (e.target && e.target.classList.contains('modal-overlay')) {
        e.target.style.display = 'none';
    }
});

// ── Delete Confirmation ───────────────────────────────────────────────────
function confirmDelete(packageId, packageName) {
    var confirmed = confirm('Delete "' + packageName + '"?\n\nThis action cannot be undone.');
    if (confirmed) {
        window.location.href = 'AdminServlet?action=delete&id=' + packageId;
    }
}

// ── Auto-Hide Alert Messages After 4.5s ──────────────────────────────────
function autoHideAlerts() {
    var alerts = document.querySelectorAll('.alert');
    for (var i = 0; i < alerts.length; i++) {
        (function (alert) {
            setTimeout(function () {
                alert.style.opacity    = '0';
                alert.style.transform  = 'translateY(-8px)';
                alert.style.transition = 'all 0.4s ease';
                setTimeout(function () {
                    if (alert.parentNode) { alert.parentNode.removeChild(alert); }
                }, 400);
            }, 4500);
        })(alerts[i]);
    }
}

// ── Set Minimum Travel Date to Tomorrow ──────────────────────────────────
function setMinDate() {
    var dateInput = document.getElementById('travelDate');
    if (!dateInput) { return; }

    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);

    var yyyy = tomorrow.getFullYear();
    var mm   = ('0' + (tomorrow.getMonth() + 1)).slice(-2);
    var dd   = ('0' + tomorrow.getDate()).slice(-2);
    dateInput.min = yyyy + '-' + mm + '-' + dd;
}

// ── Email Validation Helper ───────────────────────────────────────────────
function isValidEmail(email) {
    var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

// ── Show Inline Form Error ────────────────────────────────────────────────
function showFormError(message) {
    // Remove any existing JS error
    var existing = document.querySelectorAll('.js-error');
    for (var i = 0; i < existing.length; i++) {
        existing[i].parentNode.removeChild(existing[i]);
    }

    // Create new error div
    var div       = document.createElement('div');
    div.className = 'alert alert-error js-error';
    div.innerHTML = '<span>&#9888;</span> ' + message;

    // Insert at top of form
    var form = document.querySelector('form');
    if (form) {
        form.insertBefore(div, form.firstChild);
    }

    div.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
}

// ── DOM Ready ─────────────────────────────────────────────────────────────
document.addEventListener('DOMContentLoaded', function () {
    initSearch();
    setMinDate();
    autoHideAlerts();

    // Attach price calculator to people input on booking page
    var peopleInput = document.getElementById('people');
    if (peopleInput) {
        peopleInput.addEventListener('input', function () {
            updateTotalPrice();
            // Keep summary people count in sync
            var countEl = document.getElementById('peopleCount');
            if (countEl) { countEl.textContent = peopleInput.value || '1'; }
        });
        updateTotalPrice(); // Run once on load
    }
});
