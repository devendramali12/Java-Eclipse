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
		List<Product> list = new ArrayList<>();
		String sql = "SELECT p.*, c.category_name FROM products p LEFT JOIN categories c ON p.category_id = c.category_id";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				list.add(mapRow(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product getProductById(int productId) {
		String sql = "SELECT p.*, c.category_name FROM products p LEFT JOIN categories c ON p.category_id = c.category_id WHERE p.product_id = ?";
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

	public List<Product> getProductsByCategory(int categoryId) {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT p.*, c.category_name FROM products p LEFT JOIN categories c ON p.category_id = c.category_id WHERE p.category_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					list.add(mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> searchProducts(String keyword) {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT p.*, c.category_name FROM products p LEFT JOIN categories c ON p.category_id = c.category_id WHERE p.product_name ILIKE ? OR p.description ILIKE ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			String kw = "%" + keyword + "%";
			ps.setString(1, kw);
			ps.setString(2, kw);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					list.add(mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
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
		return p;
	}
}