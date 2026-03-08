package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.CartItem;
import com.shop.model.Order;
import com.shop.model.OrderItem;
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

	// All orders for admin
	public List<Order> getAllOrders() {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT o.*, u.full_name, u.username FROM orders o "
				+ "JOIN users u ON o.user_id = u.user_id ORDER BY o.order_date DESC";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Order o = mapRow(rs);
				o.setCustomerName(rs.getString("full_name"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Order items for invoice
	public List<OrderItem> getOrderItems(int orderId) {
		List<OrderItem> list = new ArrayList<>();
		String sql = "SELECT oi.*, p.product_name, p.image_url FROM order_items oi "
				+ "JOIN products p ON oi.product_id = p.product_id WHERE oi.order_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem item = new OrderItem();
				item.setItemId(rs.getInt("item_id"));
				item.setOrderId(orderId);
				item.setProductId(rs.getInt("product_id"));
				item.setProductName(rs.getString("product_name"));
				item.setImageUrl(rs.getString("image_url"));
				item.setQuantity(rs.getInt("quantity"));
				item.setPrice(rs.getDouble("price"));
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Order getOrderById(int orderId) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders WHERE order_id=?")) {
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Admin: update order status
	public boolean updateOrderStatus(int orderId, String status) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE orders SET status=? WHERE order_id=?")) {
			ps.setString(1, status);
			ps.setInt(2, orderId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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