package com.shop.servlet;

import java.io.IOException;

import com.shop.dao.UserDAO;
import com.shop.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login", "/register", "/logout" })
public class UserServlet extends HttpServlet {

	private final UserDAO userDAO = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/logout".equals(path)) {
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/login");
		} else if ("/register".equals(path)) {
			req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/login".equals(path)) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			User user = userDAO.authenticate(username, password);
			if (user != null) {
				req.getSession().setAttribute("loggedUser", user);
				resp.sendRedirect(req.getContextPath() + "/products");
			} else {
				req.setAttribute("error", "Invalid username or password!");
				req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			}
		} else if ("/register".equals(path)) {
			User user = new User();
			user.setUsername(req.getParameter("username"));
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			user.setFullName(req.getParameter("fullName"));
			user.setPhone(req.getParameter("phone"));
			user.setAddress(req.getParameter("address"));
			if (userDAO.registerUser(user)) {
				req.setAttribute("success", "Registration successful! Please login.");
				req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			} else {
				req.setAttribute("error", "Username or email already exists!");
				req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
			}
		}
	}
}