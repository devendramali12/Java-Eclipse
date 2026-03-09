package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 * LoginServlet.java
 * ───────────────────────────────────────────────────────────── Handles both
 * User login (/LoginServlet) and Admin login (/AdminLogin) via a shared
 * servlet. Location : src/main/java/controller/LoginServlet.java
 */
@WebServlet(urlPatterns = { "/LoginServlet", "/AdminLogin" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Hard-coded admin credentials (move to DB / env vars in production)
	private static final String ADMIN_USER = "admin";
	private static final String ADMIN_PASS = "admin123";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		if ("/AdminLogin".equals(req.getServletPath())) {
			handleAdminLogin(req, resp);
		} else {
			handleUserLogin(req, resp);
		}
	}

	// ── User Login ──────────────────────────────────────────────────────
	private void handleUserLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (email == null || email.isBlank() || password == null || password.isBlank()) {
			req.setAttribute("error", "Email and password are required.");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}

		UserDAO dao = new UserDAO();
		User user = dao.loginUser(email.trim(), password.trim());

		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			resp.sendRedirect("packages.jsp");
		} else {
			req.setAttribute("error", "Invalid email or password. Please try again.");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	// ── Admin Login ─────────────────────────────────────────────────────
	private void handleAdminLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("admin", username);
			resp.sendRedirect("admin-dashboard.jsp");
		} else {
			req.setAttribute("error", "Invalid admin credentials.");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
	}
}