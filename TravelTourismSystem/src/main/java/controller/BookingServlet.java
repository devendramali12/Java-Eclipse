package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import dao.BookingDAO;
import dao.PackageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Booking;
import model.TravelPackage;
import model.User;

/**
 * BookingServlet.java
 * ───────────────────────────────────────────────────────────── GET
 * /BookingServlet?packageId=X → load booking form POST /BookingServlet → submit
 * & confirm booking Location : src/main/java/controller/BookingServlet.java
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// ── GET — Show Booking Form ─────────────────────────────────────────
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (!isLoggedIn(req)) {
			resp.sendRedirect("login.jsp");
			return;
		}

		String pidStr = req.getParameter("packageId");
		if (pidStr == null || pidStr.isBlank()) {
			resp.sendRedirect("packages.jsp");
			return;
		}

		try {
			int id = Integer.parseInt(pidStr.trim());
			TravelPackage pkg = new PackageDAO().getPackageById(id);
			if (pkg == null) {
				resp.sendRedirect("packages.jsp");
				return;
			}

			req.setAttribute("package", pkg);
			req.getRequestDispatcher("booking.jsp").forward(req, resp);

		} catch (NumberFormatException e) {
			resp.sendRedirect("packages.jsp");
		}
	}

	// ── POST — Process Booking ──────────────────────────────────────────
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		if (!isLoggedIn(req)) {
			resp.sendRedirect("login.jsp");
			return;
		}

		User user = (User) req.getSession().getAttribute("user");
		String pidStr = req.getParameter("packageId");
		String dateStr = req.getParameter("travelDate");
		String peopleStr = req.getParameter("people");

		if (pidStr == null || dateStr == null || peopleStr == null) {
			forwardError(req, resp, "All fields are required.", pidStr);
			return;
		}

		try {
			int packageId = Integer.parseInt(pidStr.trim());
			int people = Integer.parseInt(peopleStr.trim());
			LocalDate date = LocalDate.parse(dateStr.trim());

			// Validation
			if (people < 1 || people > 20) {
				forwardError(req, resp, "Number of travellers must be 1–20.", pidStr);
				return;
			}
			if (!date.isAfter(LocalDate.now())) {
				forwardError(req, resp, "Travel date must be a future date.", pidStr);
				return;
			}

			Booking b = new Booking();
			b.setUserId(user.getId());
			b.setPackageId(packageId);
			b.setBookingDate(Date.valueOf(date));
			b.setPeople(people);

			if (new BookingDAO().createBooking(b)) {
				req.getSession().setAttribute("bookingSuccess", "Your trip is confirmed! Have a wonderful journey 🌍");
				resp.sendRedirect("my-bookings.jsp");
			} else {
				forwardError(req, resp, "Booking failed. Please try again.", pidStr);
			}

		} catch (NumberFormatException | java.time.format.DateTimeParseException e) {
			forwardError(req, resp, "Invalid input. Please check your details.", pidStr);
		}
	}

	// ── Helpers ─────────────────────────────────────────────────────────
	private boolean isLoggedIn(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("user") != null;
	}

	private void forwardError(HttpServletRequest req, HttpServletResponse resp, String msg, String packageId)
			throws ServletException, IOException {
		if (packageId != null) {
			try {
				TravelPackage pkg = new PackageDAO().getPackageById(Integer.parseInt(packageId));
				req.setAttribute("package", pkg);
			} catch (NumberFormatException ignored) {
			}
		}
		req.setAttribute("error", msg);
		req.getRequestDispatcher("booking.jsp").forward(req, resp);
	}
}