package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import com.shop.dao.ProductDAO;
import com.shop.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

	private final ProductDAO productDAO = new ProductDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("search");
		String catParam = req.getParameter("category");
		String action = req.getParameter("action");
		List<Product> products;

		if ("detail".equals(action)) {
			Product product = productDAO.getProductById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("product", product);
			req.getRequestDispatcher("/WEB-INF/views/product-detail.jsp").forward(req, resp);
			return;
		} else if (search != null && !search.trim().isEmpty()) {
			products = productDAO.searchProducts(search.trim());
			req.setAttribute("searchKeyword", search);
		} else if (catParam != null && !catParam.isEmpty()) {
			products = productDAO.getProductsByCategory(Integer.parseInt(catParam));
			req.setAttribute("selectedCategory", catParam);
		} else {
			products = productDAO.getAllProducts();
		}

		req.setAttribute("products", products);
		req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
	}
}