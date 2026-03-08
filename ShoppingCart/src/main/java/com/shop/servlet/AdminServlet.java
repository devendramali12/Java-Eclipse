package com.shop.servlet;

import java.io.IOException;

import com.shop.dao.OrderDAO;
import com.shop.dao.ProductDAO;
import com.shop.dao.UserDAO;
import com.shop.model.Product;
import com.shop.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {

	private final ProductDAO productDAO = new ProductDAO();
	private final OrderDAO orderDAO = new OrderDAO();
	private final UserDAO userDAO = new UserDAO();

	// Check admin access
	private boolean isAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user == null || !user.isAdmin()) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return false;
		}
		return true;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isAdmin(req, resp))
			return;

		String info = req.getPathInfo(); // e.g. /dashboard, /products, /orders
		if (info == null)
			info = "/dashboard";

		switch (info) {
		case "/dashboard":
			req.setAttribute("totalProducts", productDAO.getAllProducts().size());
			req.setAttribute("totalOrders", orderDAO.getAllOrders().size());
			req.setAttribute("totalUsers", userDAO.getAllUsers().size());
			req.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(req, resp);
			break;

		case "/products":
			req.setAttribute("products", productDAO.getAllProducts());
			req.setAttribute("categories", productDAO.getAllCategories());
			req.getRequestDispatcher("/WEB-INF/views/admin/products.jsp").forward(req, resp);
			break;

		case "/products/edit":
			int editId = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("product", productDAO.getProductById(editId));
			req.setAttribute("categories", productDAO.getAllCategories());
			req.getRequestDispatcher("/WEB-INF/views/admin/product-form.jsp").forward(req, resp);
			break;

		case "/products/add":
			req.setAttribute("categories", productDAO.getAllCategories());
			req.getRequestDispatcher("/WEB-INF/views/admin/product-form.jsp").forward(req, resp);
			break;

		case "/products/delete":
			productDAO.deleteProduct(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() + "/admin/products?msg=deleted");
			break;

		case "/orders":
			req.setAttribute("orders", orderDAO.getAllOrders());
			req.getRequestDispatcher("/WEB-INF/views/admin/orders.jsp").forward(req, resp);
			break;

		case "/orders/detail":
			int orderId = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("order", orderDAO.getOrderById(orderId));
			req.setAttribute("orderItems", orderDAO.getOrderItems(orderId));
			req.getRequestDispatcher("/WEB-INF/views/admin/order-detail.jsp").forward(req, resp);
			break;

		default:
			resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!isAdmin(req, resp))
			return;

		String info = req.getPathInfo();

		if ("/products/save".equals(info)) {
			Product p = new Product();
			String idStr = req.getParameter("productId");
			p.setProductName(req.getParameter("productName"));
			p.setDescription(req.getParameter("description"));
			p.setPrice(Double.parseDouble(req.getParameter("price")));
			p.setStockQuantity(Integer.parseInt(req.getParameter("stockQuantity")));
			p.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
			p.setImageUrl(req.getParameter("imageUrl"));

			if (idStr != null && !idStr.isEmpty()) {
				p.setProductId(Integer.parseInt(idStr));
				productDAO.updateProduct(p);
			} else {
				productDAO.addProduct(p);
			}
			resp.sendRedirect(req.getContextPath() + "/admin/products?msg=saved");

		} else if ("/orders/status".equals(info)) {
			int orderId = Integer.parseInt(req.getParameter("orderId"));
			String status = req.getParameter("status");
			orderDAO.updateOrderStatus(orderId, status);
			resp.sendRedirect(req.getContextPath() + "/admin/orders?msg=updated");
		}
	}
}