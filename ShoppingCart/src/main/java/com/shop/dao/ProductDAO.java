package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.Product;
import com.shop.util.DBConnection;

public class ProductDAO {

	public List<Product> getAllProducts() {
		return getFilteredProducts(null, 0, "newest", 0, 0, 1, 9999);
	}

	public List<Product> getFilteredProducts(String keyword, int categoryId, String sortBy, double minPrice,
			double maxPrice, int page, int pageSize) {

		List<Product> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT p.*, c.category_name, c.emoji FROM products p "
				+ "LEFT JOIN categories c ON p.category_id = c.category_id WHERE 1=1");

		if (keyword != null && !keyword.trim().isEmpty())
			sql.append(" AND (p.product_name ILIKE ? OR p.description ILIKE ?)");
		if (categoryId > 0)
			sql.append(" AND p.category_id = ?");
		if (maxPrice > 0)
			sql.append(" AND p.price BETWEEN ? AND ?");

		switch (sortBy == null ? "newest" : sortBy) {
		case "price_asc":
			sql.append(" ORDER BY p.price ASC");
			break;
		case "price_desc":
			sql.append(" ORDER BY p.price DESC");
			break;
		case "name_asc":
			sql.append(" ORDER BY p.product_name ASC");
			break;
		default:
			sql.append(" ORDER BY p.product_id DESC");
			break;
		}

		boolean paginate = (pageSize < 9999);
		if (paginate)
			sql.append(" LIMIT ? OFFSET ?");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			int idx = 1;
			if (keyword != null && !keyword.trim().isEmpty()) {
				String kw = "%" + keyword.trim() + "%";
				ps.setString(idx++, kw);
				ps.setString(idx++, kw);
			}
			if (categoryId > 0)
				ps.setInt(idx++, categoryId);
			if (maxPrice > 0) {
				ps.setDouble(idx++, minPrice);
				ps.setDouble(idx++, maxPrice);
			}
			if (paginate) {
				ps.setInt(idx++, pageSize);
				ps.setInt(idx, (page - 1) * pageSize);
			}
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					list.add(mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int countFilteredProducts(String keyword, int categoryId, double minPrice, double maxPrice) {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM products p WHERE 1=1");
		if (keyword != null && !keyword.trim().isEmpty())
			sql.append(" AND (p.product_name ILIKE ? OR p.description ILIKE ?)");
		if (categoryId > 0)
			sql.append(" AND p.category_id = ?");
		if (maxPrice > 0)
			sql.append(" AND p.price BETWEEN ? AND ?");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			int idx = 1;
			if (keyword != null && !keyword.trim().isEmpty()) {
				String kw = "%" + keyword.trim() + "%";
				ps.setString(idx++, kw);
				ps.setString(idx++, kw);
			}
			if (categoryId > 0)
				ps.setInt(idx++, categoryId);
			if (maxPrice > 0) {
				ps.setDouble(idx++, minPrice);
				ps.setDouble(idx++, maxPrice);
			}
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Product getProductById(int productId) {
		String sql = "SELECT p.*, c.category_name, c.emoji FROM products p "
				+ "LEFT JOIN categories c ON p.category_id = c.category_id " + "WHERE p.product_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, productId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addProduct(Product p) {
		String sql = "INSERT INTO products "
				+ "(product_name, description, price, stock_quantity, category_id, image_url) "
				+ "VALUES (?,?,?,?,?,?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getDescription());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getStockQuantity());
			ps.setInt(5, p.getCategoryId());
			ps.setString(6, p.getImageUrl());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(Product p) {
		String sql = "UPDATE products SET product_name=?, description=?, price=?, "
				+ "stock_quantity=?, category_id=?, image_url=? WHERE product_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getDescription());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getStockQuantity());
			ps.setInt(5, p.getCategoryId());
			ps.setString(6, p.getImageUrl());
			ps.setInt(7, p.getProductId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProduct(int productId) {
		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement del1 = conn.prepareStatement("DELETE FROM cart WHERE product_id=?");
			del1.setInt(1, productId);
			del1.executeUpdate();
			PreparedStatement del2 = conn.prepareStatement("DELETE FROM products WHERE product_id=?");
			del2.setInt(1, productId);
			return del2.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String[]> getAllCategories() {
		return new CategoryDAO().getAllCategoryPairs();
	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setProductId(rs.getInt("product_id"));
		p.setProductName(rs.getString("product_name"));
		p.setDescription(rs.getString("description"));
		p.setPrice(rs.getDouble("price"));
		p.setStockQuantity(rs.getInt("stock_quantity"));
		p.setCategoryId(rs.getInt("category_id"));
		p.setCategoryName(rs.getString("category_name"));
		p.setImageUrl(rs.getString("image_url"));
		try {
			p.setCategoryEmoji(rs.getString("emoji"));
		} catch (SQLException ignored) {
		}
		return p;
	}
}