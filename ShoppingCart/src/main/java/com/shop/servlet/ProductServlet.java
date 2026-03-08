package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import com.shop.dao.CartDAO;
import com.shop.dao.CategoryDAO;
import com.shop.dao.ProductDAO;
import com.shop.model.Product;
import com.shop.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

	private final ProductDAO productDAO = new ProductDAO();
	private final CartDAO cartDAO = new CartDAO();
	private final CategoryDAO categoryDAO = new CategoryDAO();
	private static final int PAGE_SIZE = 12;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user != null)
			req.getSession().setAttribute("cartCount", cartDAO.getCartCount(user.getUserId()));

		String action = req.getParameter("action");
		if ("detail".equals(action)) {
			try {
				int productId = Integer.parseInt(req.getParameter("id"));
				Product product = productDAO.getProductById(productId);
				if (product == null) {
					resp.sendRedirect(req.getContextPath() + "/products");
					return;
				}
				req.setAttribute("product", product);
				req.setAttribute("categories", categoryDAO.getAllActiveCategories());
				req.getRequestDispatcher("/WEB-INF/views/product-detail.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				resp.sendRedirect(req.getContextPath() + "/products");
			}
			return;
		}

		String keyword = req.getParameter("search");
		String catParam = req.getParameter("category");
		String sortBy = req.getParameter("sort");
		String minPriceStr = req.getParameter("minPrice");
		String maxPriceStr = req.getParameter("maxPrice");
		String pageStr = req.getParameter("page");

		int categoryId = parseIntSafe(catParam, 0);
		double minPrice = parseDoubleSafe(minPriceStr, 0);
		double maxPrice = parseDoubleSafe(maxPriceStr, 0);
		int currentPage = Math.max(1, parseIntSafe(pageStr, 1));

		int totalCount = productDAO.countFilteredProducts(keyword, categoryId, minPrice, maxPrice);
		int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE);
		List<Product> products = productDAO.getFilteredProducts(keyword, categoryId, sortBy, minPrice, maxPrice,
				currentPage, PAGE_SIZE);

		req.setAttribute("products", products);
		req.setAttribute("searchKeyword", keyword);
		req.setAttribute("selectedCategory", catParam);
		req.setAttribute("selectedSort", sortBy);
		req.setAttribute("minPrice", minPriceStr);
		req.setAttribute("maxPrice", maxPriceStr);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("totalProducts", totalCount);
		req.setAttribute("categories", categoryDAO.getAllActiveCategories());

		req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
	}

	private int parseIntSafe(String s, int def) {
		try {
			return (s != null && !s.isEmpty()) ? Integer.parseInt(s) : def;
		} catch (NumberFormatException e) {
			return def;
		}
	}

	private double parseDoubleSafe(String s, double d) {
		try {
			return (s != null && !s.isEmpty()) ? Double.parseDouble(s) : d;
		} catch (NumberFormatException e) {
			return d;
		}
	}
}