package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import com.shop.dao.CartDAO;
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
	private static final int PAGE_SIZE = 12;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Cart count badge
		User user = (User) req.getSession().getAttribute("loggedUser");
		if (user != null) {
			req.getSession().setAttribute("cartCount", cartDAO.getCartCount(user.getUserId()));
		}

		String action = req.getParameter("action");

		// Product detail page
		if ("detail".equals(action)) {
			int productId = Integer.parseInt(req.getParameter("id"));
			Product product = productDAO.getProductById(productId);
			req.setAttribute("product", product);
			req.setAttribute("categories", productDAO.getAllCategories());
			req.getRequestDispatcher("/WEB-INF/views/product-detail.jsp").forward(req, resp);
			return;
		}

		// Filters
		String keyword = req.getParameter("search");
		String catParam = req.getParameter("category");
		String sortBy = req.getParameter("sort");
		String minPriceStr = req.getParameter("minPrice");
		String maxPriceStr = req.getParameter("maxPrice");
		String pageStr = req.getParameter("page");

		int categoryId = (catParam != null && !catParam.isEmpty()) ? Integer.parseInt(catParam) : 0;
		double minPrice = (minPriceStr != null && !minPriceStr.isEmpty()) ? Double.parseDouble(minPriceStr) : 0;
		double maxPrice = (maxPriceStr != null && !maxPriceStr.isEmpty()) ? Double.parseDouble(maxPriceStr) : 0;
		int currentPage = (pageStr != null && !pageStr.isEmpty()) ? Integer.parseInt(pageStr) : 1;
		if (currentPage < 1)
			currentPage = 1;

		int totalProducts = productDAO.countFilteredProducts(keyword, categoryId, minPrice, maxPrice);
		int totalPages = (int) Math.ceil((double) totalProducts / PAGE_SIZE);
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
		req.setAttribute("totalProducts", totalProducts);
		req.setAttribute("categories", productDAO.getAllCategories());
		req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
	}
}