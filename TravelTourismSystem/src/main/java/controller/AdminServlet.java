package controller;

import java.io.IOException;
import java.math.BigDecimal;

import dao.PackageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TravelPackage;

/**
 * AdminServlet.java
 * ───────────────────────────────────────────────────────────── Handles admin
 * CRUD operations for travel packages. Location :
 * src/main/java/controller/AdminServlet.java
 *
 * URL Mappings: GET /AdminServlet?action=delete&id=X → delete package POST
 * /AdminServlet action=add → add new package POST /AdminServlet action=update →
 * update package POST /AdminServlet action=delete → delete package
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// ── Admin Auth Guard ────────────────────────────────────────────────
	private boolean isAdmin(HttpServletRequest req) {
		HttpSession s = req.getSession(false);
		return s != null && s.getAttribute("admin") != null;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isAdmin(req)) {
			resp.sendRedirect("admin-login.jsp");
			return;
		}
		if ("delete".equals(req.getParameter("action"))) {
			handleDelete(req, resp);
		} else {
			resp.sendRedirect("admin-dashboard.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if (!isAdmin(req)) {
			resp.sendRedirect("admin-login.jsp");
			return;
		}

		String action = req.getParameter("action");
		if (action == null)
			action = "";

		switch (action) {
		case "add" -> handleAdd(req, resp);
		case "update" -> handleUpdate(req, resp);
		case "delete" -> handleDelete(req, resp);
		default -> resp.sendRedirect("admin-dashboard.jsp");
		}
	}

	// ── Add New Package ─────────────────────────────────────────────────
	private void handleAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			TravelPackage pkg = buildFromRequest(req);
			boolean ok = new PackageDAO().addPackage(pkg);
			if (ok) {
				flash(req, "adminMsg", "Package \"" + pkg.getPackageName() + "\" added successfully!");
			} else {
				flash(req, "adminError", "Failed to add package. Please try again.");
			}
		} catch (IllegalArgumentException e) {
			flash(req, "adminError", "Validation error: " + e.getMessage());
		}
		resp.sendRedirect("admin-dashboard.jsp");
	}

	// ── Update Existing Package ─────────────────────────────────────────
	private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String pidStr = req.getParameter("packageId");
			if (pidStr == null || pidStr.isBlank()) {
				flash(req, "adminError", "Package ID is missing.");
				resp.sendRedirect("admin-dashboard.jsp");
				return;
			}
			int id = Integer.parseInt(pidStr.trim());
			TravelPackage pkg = buildFromRequest(req);
			pkg.setId(id);

			boolean ok = new PackageDAO().updatePackage(pkg);
			if (ok) {
				flash(req, "adminMsg", "Package \"" + pkg.getPackageName() + "\" updated successfully!");
			} else {
				flash(req, "adminError", "Failed to update package. Please try again.");
			}
		} catch (NumberFormatException e) {
			flash(req, "adminError", "Invalid package ID.");
		} catch (IllegalArgumentException e) {
			flash(req, "adminError", "Validation error: " + e.getMessage());
		}
		resp.sendRedirect("admin-dashboard.jsp");
	}

	// ── Delete Package ──────────────────────────────────────────────────
	private void handleDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String idStr = req.getParameter("id");
			if (idStr == null || idStr.isBlank()) {
				flash(req, "adminError", "Package ID is missing.");
				resp.sendRedirect("admin-dashboard.jsp");
				return;
			}
			int id = Integer.parseInt(idStr.trim());
			boolean ok = new PackageDAO().deletePackage(id);
			if (ok) {
				flash(req, "adminMsg", "Package deleted successfully.");
			} else {
				flash(req, "adminError", "Could not delete package. It may have existing bookings.");
			}
		} catch (NumberFormatException e) {
			flash(req, "adminError", "Invalid package ID.");
		}
		resp.sendRedirect("admin-dashboard.jsp");
	}

	// ── Build TravelPackage from Form Parameters ────────────────────────
	private TravelPackage buildFromRequest(HttpServletRequest req) {
		String name = req.getParameter("packageName");
		String location = req.getParameter("location");
		String priceStr = req.getParameter("price");
		String duration = req.getParameter("duration");
		String desc = req.getParameter("description");
		String imgUrl = req.getParameter("imageUrl");

		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Package name is required.");
		if (location == null || location.isBlank())
			throw new IllegalArgumentException("Location is required.");
		if (priceStr == null || priceStr.isBlank())
			throw new IllegalArgumentException("Price is required.");

		BigDecimal price;
		try {
			price = new BigDecimal(priceStr.trim());
			if (price.compareTo(BigDecimal.ZERO) <= 0)
				throw new IllegalArgumentException("Price must be a positive number.");
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Price must be a valid number.");
		}

		TravelPackage pkg = new TravelPackage();
		pkg.setPackageName(name.trim());
		pkg.setLocation(location.trim());
		pkg.setPrice(price);
		pkg.setDuration(duration != null ? duration.trim() : "");
		pkg.setDescription(desc != null ? desc.trim() : "");
		pkg.setImageUrl(imgUrl != null ? imgUrl.trim() : "");
		return pkg;
	}

	// ── Flash Message Helper ────────────────────────────────────────────
	private void flash(HttpServletRequest req, String key, String msg) {
		req.getSession().setAttribute(key, msg);
	}
}