package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.CartItem;
import com.shop.model.Order;
import com.shop.util.DBConnection;

public class OrderDAO {

	public int placeOrder(int userId, List<CartItem> cartItems, String shippingAddress) {
		double total = cartItems.stream().mapToDouble(CartItem::getSubtotal).sum();
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement orderPs = conn.prepareStatement(
					"INSERT INTO orders (user_id, total_amount, shipping_address) VALUES (?,?,?) RETURNING order_id");
			orderPs.setInt(1, userId);
			orderPs.setDouble(2, total);
			orderPs.setString(3, shippingAddress);

			ResultSet rs = orderPs.executeQuery();
			if (!rs.next()) {
				conn.rollback();
				return -1;
			}
			int orderId = rs.getInt(1);

			PreparedStatement itemPs = conn.prepareStatement(
					"INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?,?,?,?)");
			for (CartItem item : cartItems) {
				itemPs.setInt(1, orderId);
				itemPs.setInt(2, item.getProductId());
				itemPs.setInt(3, item.getQuantity());
				itemPs.setDouble(4, item.getPrice());
				itemPs.addBatch();
			}
			itemPs.executeBatch();
			conn.commit();
			return orderId;

		} catch (SQLException e) {
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn);
		}
		return -1;
	}

	public List<Order> getOrdersByUser(int userId) {
		List<Order> list = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT * FROM orders WHERE user_id=? ORDER BY order_date DESC")) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				list.add(mapRow(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Order mapRow(ResultSet rs) throws SQLException {
		Order o = new Order();
		o.setOrderId(rs.getInt("order_id"));
		o.setUserId(rs.getInt("user_id"));
		o.setTotalAmount(rs.getDouble("total_amount"));
		o.setStatus(rs.getString("status"));
		o.setShippingAddress(rs.getString("shipping_address"));
		o.setOrderDate(rs.getTimestamp("order_date"));
		return o;
	}
}