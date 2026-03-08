package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import com.shop.dao.CartDAO;
import com.shop.dao.OrderDAO;
import com.shop.model.CartItem;
import com.shop.model.Order;
import com.shop.model.OrderItem;
import com.shop.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/checkout", "/orders", "/order-detail" })
public class OrderServlet extends HttpServlet {

	private final CartDAO cartDAO = new CartDAO();
	private final OrderDAO orderDAO = new OrderDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String path = req.getServletPath();
		if ("/checkout".equals(path)) {
			List<CartItem> cartItems = cartDAO.getCartItems(user.getUserId());
			if (cartItems.isEmpty()) {
				resp.sendRedirect(req.getContextPath() + "/cart");
				return;
			}
			req.setAttribute("cartItems", cartItems);
			req.setAttribute("grandTotal", cartItems.stream().mapToDouble(CartItem::getSubtotal).sum());
			req.setAttribute("user", user);
			req.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(req, resp);

		} else if ("/orders".equals(path)) {
			req.setAttribute("orders", orderDAO.getOrdersByUser(user.getUserId()));
			req.getRequestDispatcher("/WEB-INF/views/orders.jsp").forward(req, resp);

		} else if ("/order-detail".equals(path)) {
			int orderId = Integer.parseInt(req.getParameter("id"));
			Order order = orderDAO.getOrderById(orderId);
			// Security: only owner can see their order
			if (order == null || (order.getUserId() != user.getUserId() && !user.isAdmin())) {
				resp.sendRedirect(req.getContextPath() + "/orders");
				return;
			}
			List<OrderItem> items = orderDAO.getOrderItems(orderId);
			req.setAttribute("order", order);
			req.setAttribute("orderItems", items);
			req.getRequestDispatcher("/WEB-INF/views/order-detail.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		List<CartItem> cartItems = cartDAO.getCartItems(user.getUserId());
		int orderId = orderDAO.placeOrder(user.getUserId(), cartItems, req.getParameter("shippingAddress"));
		if (orderId > 0) {
			cartDAO.clearCart(user.getUserId());
			req.getSession().setAttribute("cartCount", 0);
			req.setAttribute("orderId", orderId);
			req.getRequestDispatcher("/WEB-INF/views/order-success.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/checkout");
		}
	}
}