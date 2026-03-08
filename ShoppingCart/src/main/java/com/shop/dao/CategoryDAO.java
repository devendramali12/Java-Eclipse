package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.Category;
import com.shop.util.DBConnection;

public class CategoryDAO {

	public List<Category> getAllActiveCategories() {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM categories WHERE is_active = TRUE ORDER BY category_id";
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

	public List<Category> getAllCategories() {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT c.*, COUNT(p.product_id) AS product_count "
				+ "FROM categories c LEFT JOIN products p ON c.category_id = p.category_id "
				+ "GROUP BY c.category_id ORDER BY c.category_id";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Category cat = mapRow(rs);
				cat.setProductCount(rs.getInt("product_count"));
				list.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Category getCategoryById(int id) {
		String sql = "SELECT * FROM categories WHERE category_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addCategory(Category cat) {
		String sql = "INSERT INTO categories (category_name, description, emoji, is_active) VALUES (?,?,?,?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cat.getCategoryName());
			ps.setString(2, cat.getDescription());
			ps.setString(3, cat.getEmoji());
			ps.setBoolean(4, cat.isActive());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCategory(Category cat) {
		String sql = "UPDATE categories SET category_name=?, description=?, emoji=?, is_active=? WHERE category_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cat.getCategoryName());
			ps.setString(2, cat.getDescription());
			ps.setString(3, cat.getEmoji());
			ps.setBoolean(4, cat.isActive());
			ps.setInt(5, cat.getCategoryId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String deleteCategory(int id) {
		String check = "SELECT COUNT(*) FROM products WHERE category_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(check)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next() && rs.getInt(1) > 0)
				return "HASPRODUCTS";
		} catch (SQLException e) {
			e.printStackTrace();
			return "ERROR";
		}

		String sql = "DELETE FROM categories WHERE category_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0 ? "OK" : "ERROR";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "ERROR";
	}

	public boolean toggleActive(int id) {
		String sql = "UPDATE categories SET is_active = NOT is_active WHERE category_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String[]> getAllCategoryPairs() {
		List<String[]> list = new ArrayList<>();
		String sql = "SELECT category_id, category_name FROM categories WHERE is_active=TRUE ORDER BY category_id";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				list.add(new String[] { rs.getString(1), rs.getString(2) });
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Category mapRow(ResultSet rs) throws SQLException {
		Category c = new Category();
		c.setCategoryId(rs.getInt("category_id"));
		c.setCategoryName(rs.getString("category_name"));
		c.setDescription(rs.getString("description"));
		c.setEmoji(rs.getString("emoji"));
		c.setActive(rs.getBoolean("is_active"));
		return c;
	}
}