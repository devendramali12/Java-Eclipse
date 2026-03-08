package com.shop.servlet;

import java.io.IOException;

import com.shop.dao.UserDAO;
import com.shop.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login", "/register", "/logout", "/profile" })
public class UserServlet extends HttpServlet {

	private final UserDAO userDAO = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/logout":
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/login");
			break;
		case "/register":
			req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
			break;
		case "/profile":
			User u = (User) req.getSession().getAttribute("loggedUser");
			if (u == null) {
				resp.sendRedirect(req.getContextPath() + "/login");
				return;
			}
			req.setAttribute("user", userDAO.getUserById(u.getUserId()));
			req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
			break;
		default:
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		if ("/login".equals(path)) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if (username == null || username.trim().isEmpty() || password == null || password.isEmpty()) {
				req.setAttribute("error", "Username and password are required.");
				req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
				return;
			}
			User user = userDAO.authenticate(username.trim(), password);
			if (user != null) {
				req.getSession().setAttribute("loggedUser", user);
				resp.sendRedirect(req.getContextPath() + "/products");
			} else {
				req.setAttribute("error", "Invalid username or password.");
				req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			}

		} else if ("/register".equals(path)) {
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String confirm = req.getParameter("confirmPassword");
			String fullName = req.getParameter("fullName");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");

			if (username == null || username.trim().length() < 3) {
				req.setAttribute("error", "Username must be at least 3 characters.");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
				return;
			}
			if (!username.matches("[a-zA-Z0-9_]+")) {
				req.setAttribute("error", "Username: only letters, numbers, underscore.");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
				return;
			}
			if (email == null || !email.contains("@")) {
				req.setAttribute("error", "Enter a valid email address.");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
				return;
			}
			if (password == null || password.length() < 6) {
				req.setAttribute("error", "Password must be at least 6 characters.");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
				return;
			}
			if (!password.equals(confirm)) {
				req.setAttribute("error", "Passwords do not match.");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
				return;
			}
			if (fullName == null || fullName.trim().length() < 3) {
				req.setAttribute("error", "Enter your full name (min 3 characters).");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
				return;
			}
			if (phone != null && !phone.isEmpty() && !phone.matches("[0-9]{10}")) {
				req.setAttribute("error", "Phone must be exactly 10 digits.");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
				return;
			}

			User user = new User();
			user.setUsername(username.trim().toLowerCase());
			user.setEmail(email.trim().toLowerCase());
			user.setPassword(password);
			user.setFullName(fullName.trim());
			user.setPhone(phone != null ? phone.trim() : "");
			user.setAddress(address != null ? address.trim() : "");

			if (userDAO.registerUser(user)) {
				req.setAttribute("success", "Account created! Please sign in.");
				req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			} else {
				req.setAttribute("error", "Username or email already taken.");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
			}

		} else if ("/profile".equals(path)) {
			User loggedUser = (User) req.getSession().getAttribute("loggedUser");
			if (loggedUser == null) {
				resp.sendRedirect(req.getContextPath() + "/login");
				return;
			}

			String action = req.getParameter("action");

			if ("updateProfile".equals(action)) {
				loggedUser.setFullName(req.getParameter("fullName"));
				loggedUser.setPhone(req.getParameter("phone"));
				loggedUser.setAddress(req.getParameter("address"));
				if (userDAO.updateProfile(loggedUser)) {
					req.getSession().setAttribute("loggedUser", userDAO.getUserById(loggedUser.getUserId()));
					req.setAttribute("success", "Profile updated successfully!");
				} else {
					req.setAttribute("error", "Failed to update profile.");
				}
				req.setAttribute("user", userDAO.getUserById(loggedUser.getUserId()));
				req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);

			} else if ("changePassword".equals(action)) {
				String oldPwd = req.getParameter("oldPassword");
				String newPwd = req.getParameter("newPassword");
				String conPwd = req.getParameter("confirmNewPassword");
				if (!newPwd.equals(conPwd)) {
					req.setAttribute("pwdError", "New passwords do not match.");
				} else if (newPwd.length() < 6) {
					req.setAttribute("pwdError", "New password must be at least 6 characters.");
				} else if (userDAO.changePassword(loggedUser.getUserId(), oldPwd, newPwd)) {
					req.setAttribute("pwdSuccess", "Password changed successfully!");
				} else {
					req.setAttribute("pwdError", "Current password is incorrect.");
				}
				req.setAttribute("user", userDAO.getUserById(loggedUser.getUserId()));
				req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
			}
		}
	}
}