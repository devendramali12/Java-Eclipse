package com.shop.servlet;

import java.io.IOException;

import com.shop.dao.CategoryDAO;
import com.shop.dao.OrderDAO;
import com.shop.dao.ProductDAO;
import com.shop.dao.UserDAO;
import com.shop.model.Category;
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
	private final CategoryDAO categoryDAO = new CategoryDAO();

	private boolean checkAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user == null || !user.isAdmin()) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return false;
		}
		return true;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!checkAdmin(req, resp))
			return;

		String info = req.getPathInfo();
		if (info == null || info.equals("/"))
			info = "/dashboard";

		switch (info) {

		case "/dashboard":
			req.setAttribute("totalProducts", productDAO.getAllProducts().size());
			req.setAttribute("totalOrders", orderDAO.getAllOrders().size());
			req.setAttribute("totalUsers", userDAO.getAllUsers().size());
			req.setAttribute("totalCategories", categoryDAO.getAllCategories().size());
			req.setAttribute("totalRevenue", orderDAO.getTotalRevenue());
			req.setAttribute("todayRevenue", orderDAO.getTodayRevenue());
			req.setAttribute("todayOrders", orderDAO.getTodayOrderCount());
			req.setAttribute("monthlyRevenue", orderDAO.getMonthlyRevenue());
			req.setAttribute("statusCounts", orderDAO.getOrderStatusCounts());
			req.setAttribute("topProducts", orderDAO.getTopProducts());
			req.setAttribute("revenueByCategory", orderDAO.getRevenueByCategory());
			req.setAttribute("lowStock", orderDAO.getLowStockProducts(10));
			req.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(req, resp);
			break;

		case "/products":
			req.setAttribute("products", productDAO.getAllProducts());
			req.setAttribute("categories", productDAO.getAllCategories());
			req.getRequestDispatcher("/WEB-INF/views/admin/products.jsp").forward(req, resp);
			break;

		case "/products/add":
			req.setAttribute("categories", productDAO.getAllCategories());
			req.getRequestDispatcher("/WEB-INF/views/admin/product-form.jsp").forward(req, resp);
			break;

		case "/products/edit":
			try {
				req.setAttribute("product", productDAO.getProductById(Integer.parseInt(req.getParameter("id"))));
				req.setAttribute("categories", productDAO.getAllCategories());
				req.getRequestDispatcher("/WEB-INF/views/admin/product-form.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				resp.sendRedirect(req.getContextPath() + "/admin/products");
			}
			break;

		case "/products/delete":
			try {
				productDAO.deleteProduct(Integer.parseInt(req.getParameter("id")));
			} catch (NumberFormatException ignored) {
			}
			resp.sendRedirect(req.getContextPath() + "/admin/products?msg=deleted");
			break;

		case "/orders":
			req.setAttribute("orders", orderDAO.getAllOrders());
			req.getRequestDispatcher("/WEB-INF/views/admin/orders.jsp").forward(req, resp);
			break;

		case "/orders/detail":
			try {
				int id = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("order", orderDAO.getOrderById(id));
				req.setAttribute("orderItems", orderDAO.getOrderItems(id));
				req.getRequestDispatcher("/WEB-INF/views/admin/order-detail.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				resp.sendRedirect(req.getContextPath() + "/admin/orders");
			}
			break;

		case "/categories":
			req.setAttribute("categories", categoryDAO.getAllCategories());
			req.getRequestDispatcher("/WEB-INF/views/admin/categories.jsp").forward(req, resp);
			break;

		case "/categories/add":
			req.getRequestDispatcher("/WEB-INF/views/admin/category-form.jsp").forward(req, resp);
			break;

		case "/categories/edit":
			try {
				req.setAttribute("category", categoryDAO.getCategoryById(Integer.parseInt(req.getParameter("id"))));
				req.getRequestDispatcher("/WEB-INF/views/admin/category-form.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				resp.sendRedirect(req.getContextPath() + "/admin/categories");
			}
			break;

		case "/categories/delete":
			try {
				String res = categoryDAO.deleteCategory(Integer.parseInt(req.getParameter("id")));
				if ("HASPRODUCTS".equals(res))
					resp.sendRedirect(req.getContextPath() + "/admin/categories?msg=hasproducts");
				else if ("OK".equals(res))
					resp.sendRedirect(req.getContextPath() + "/admin/categories?msg=deleted");
				else
					resp.sendRedirect(req.getContextPath() + "/admin/categories?msg=error");
			} catch (NumberFormatException e) {
				resp.sendRedirect(req.getContextPath() + "/admin/categories");
			}
			break;

		case "/categories/toggle":
			try {
				categoryDAO.toggleActive(Integer.parseInt(req.getParameter("id")));
			} catch (NumberFormatException ignored) {
			}
			resp.sendRedirect(req.getContextPath() + "/admin/categories?msg=toggled");
			break;

		default:
			resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!checkAdmin(req, resp))
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
			String img = req.getParameter("imageUrl");
			p.setImageUrl(img != null ? img.trim() : "");
			if (idStr != null && !idStr.trim().isEmpty()) {
				p.setProductId(Integer.parseInt(idStr));
				productDAO.updateProduct(p);
			} else {
				productDAO.addProduct(p);
			}
			resp.sendRedirect(req.getContextPath() + "/admin/products?msg=saved");

		} else if ("/orders/status".equals(info)) {
			try {
				orderDAO.updateOrderStatus(Integer.parseInt(req.getParameter("orderId")), req.getParameter("status"));
			} catch (NumberFormatException ignored) {
			}
			resp.sendRedirect(req.getContextPath() + "/admin/orders?msg=updated");

		} else if ("/categories/save".equals(info)) {
			Category cat = new Category();
			String idStr = req.getParameter("categoryId");
			cat.setCategoryName(req.getParameter("categoryName"));
			cat.setDescription(req.getParameter("description"));
			cat.setEmoji(req.getParameter("emoji") != null ? req.getParameter("emoji").trim() : "🛍️");
			cat.setActive("on".equals(req.getParameter("isActive")));
			if (idStr != null && !idStr.trim().isEmpty()) {
				cat.setCategoryId(Integer.parseInt(idStr));
				categoryDAO.updateCategory(cat);
			} else {
				categoryDAO.addCategory(cat);
			}
			resp.sendRedirect(req.getContextPath() + "/admin/categories?msg=saved");
		}
	}
}