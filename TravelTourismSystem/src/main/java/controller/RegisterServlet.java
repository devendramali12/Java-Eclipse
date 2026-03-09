package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 * RegisterServlet.java
 * ───────────────────────────────────────────────────────────── Handles new
 * user registration with server-side validation. Location :
 * src/main/java/controller/RegisterServlet.java
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");

		// ── Server-side validation ──────────────────────────────────────
		if (isBlank(name) || isBlank(email) || isBlank(password)) {
			forward(req, resp, "Name, email and password are required.", null);
			return;
		}
		if (!email.matches("^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
			forward(req, resp, "Please enter a valid email address.", null);
			return;
		}
		if (password.length() < 6) {
			forward(req, resp, "Password must be at least 6 characters long.", null);
			return;
		}

		UserDAO dao = new UserDAO();

		if (dao.emailExists(email.trim())) {
			forward(req, resp, "An account with this email already exists. Please log in.", null);
			return;
		}

		// ── Build and save User ─────────────────────────────────────────
		User user = new User();
		user.setName(name.trim());
		user.setEmail(email.trim());
		user.setPassword(password); // BCrypt in production!
		user.setPhone(phone != null ? phone.trim() : "");

		if (dao.registerUser(user)) {
			req.setAttribute("success", "Registration successful! Please log in.");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			forward(req, resp, "Registration failed. Please try again.", null);
		}
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp, String error, String success)
			throws ServletException, IOException {
		req.setAttribute("error", error);
		req.setAttribute("success", success);
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}

	private boolean isBlank(String s) {
		return s == null || s.isBlank();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("register.jsp");
	}
}