package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.CartItem;
import com.shop.util.DBConnection;

public class CartDAO {

	public List<CartItem> getCartItems(int userId) {
		List<CartItem> list = new ArrayList<>();
		String sql = "SELECT c.cart_id, c.product_id, p.product_name, p.price, c.quantity, p.image_url "
				+ "FROM cart c JOIN products p ON c.product_id = p.product_id WHERE c.user_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					CartItem item = new CartItem();
					item.setCartId(rs.getInt("cart_id"));
					item.setUserId(userId);
					item.setProductId(rs.getInt("product_id"));
					item.setProductName(rs.getString("product_name"));
					item.setPrice(rs.getDouble("price"));
					item.setQuantity(rs.getInt("quantity"));
					item.setImageUrl(rs.getString("image_url"));
					list.add(item);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addToCart(int userId, int productId, int quantity) {
		String checkSql = "SELECT cart_id, quantity FROM cart WHERE user_id=? AND product_id=?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement check = conn.prepareStatement(checkSql)) {
			check.setInt(1, userId);
			check.setInt(2, productId);
			ResultSet rs = check.executeQuery();
			if (rs.next()) {
				int newQty = rs.getInt("quantity") + quantity;
				PreparedStatement upd = conn
						.prepareStatement("UPDATE cart SET quantity=? WHERE user_id=? AND product_id=?");
				upd.setInt(1, newQty);
				upd.setInt(2, userId);
				upd.setInt(3, productId);
				return upd.executeUpdate() > 0;
			} else {
				PreparedStatement ins = conn
						.prepareStatement("INSERT INTO cart (user_id, product_id, quantity) VALUES (?,?,?)");
				ins.setInt(1, userId);
				ins.setInt(2, productId);
				ins.setInt(3, quantity);
				return ins.executeUpdate() > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCartItem(int cartId, int quantity) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE cart SET quantity=? WHERE cart_id=?")) {
			ps.setInt(1, quantity);
			ps.setInt(2, cartId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeFromCart(int cartId) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM cart WHERE cart_id=?")) {
			ps.setInt(1, cartId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean clearCart(int userId) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM cart WHERE user_id=?")) {
			ps.setInt(1, userId);
			return ps.executeUpdate() >= 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}