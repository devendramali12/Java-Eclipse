package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import com.shop.dao.CartDAO;
import com.shop.model.CartItem;
import com.shop.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	private final CartDAO cartDAO = new CartDAO();

	private void updateCartCount(HttpServletRequest req, int userId) {
		req.getSession().setAttribute("cartCount", cartDAO.getCartCount(userId));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		if ("remove".equals(req.getParameter("action"))) {
			cartDAO.removeFromCart(Integer.parseInt(req.getParameter("cartId")));
			updateCartCount(req, user.getUserId());
			resp.sendRedirect(req.getContextPath() + "/cart");
			return;
		}

		List<CartItem> cartItems = cartDAO.getCartItems(user.getUserId());
		double grandTotal = cartItems.stream().mapToDouble(CartItem::getSubtotal).sum();
		req.setAttribute("cartItems", cartItems);
		req.setAttribute("grandTotal", grandTotal);
		updateCartCount(req, user.getUserId());
		req.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String action = req.getParameter("action");
		if ("add".equals(action)) {
			cartDAO.addToCart(user.getUserId(), Integer.parseInt(req.getParameter("productId")),
					Integer.parseInt(req.getParameter("quantity")));
			updateCartCount(req, user.getUserId());
			resp.sendRedirect(req.getContextPath() + "/cart");
		} else if ("update".equals(action)) {
			int qty = Integer.parseInt(req.getParameter("quantity"));
			int cartId = Integer.parseInt(req.getParameter("cartId"));
			if (qty <= 0)
				cartDAO.removeFromCart(cartId);
			else
				cartDAO.updateCartItem(cartId, qty);
			updateCartCount(req, user.getUserId());
			resp.sendRedirect(req.getContextPath() + "/cart");
		}
	}
}