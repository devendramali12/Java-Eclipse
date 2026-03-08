package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		String sql = "SELECT * FROM orders WHERE user_id=? ORDER BY order_date DESC";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				list.add(mapRow(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Order> getAllOrders() {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT o.*, u.full_name FROM orders o "
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

	public Order getOrderById(int orderId) {
		String sql = "SELECT o.*, u.full_name FROM orders o "
				+ "JOIN users u ON o.user_id = u.user_id WHERE o.order_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Order o = mapRow(rs);
				o.setCustomerName(rs.getString("full_name"));
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

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

	public boolean updateOrderStatus(int orderId, String status) {
		String sql = "UPDATE orders SET status=? WHERE order_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setInt(2, orderId);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public double getTotalRevenue() {
		String sql = "SELECT COALESCE(SUM(total_amount),0) FROM orders WHERE status='DELIVERED'";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next())
				return rs.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double getTodayRevenue() {
		String sql = "SELECT COALESCE(SUM(total_amount),0) FROM orders "
				+ "WHERE order_date::date = CURRENT_DATE AND status != 'CANCELLED'";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next())
				return rs.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTodayOrderCount() {
		String sql = "SELECT COUNT(*) FROM orders WHERE order_date::date = CURRENT_DATE";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Map<String, Double> getMonthlyRevenue() {
		Map<String, Double> map = new LinkedHashMap<>();
		String sql = "SELECT TO_CHAR(order_date,'Mon YYYY') AS month, "
				+ "       DATE_TRUNC('month', order_date) AS sort_key, "
				+ "       COALESCE(SUM(total_amount),0) AS revenue "
				+ "FROM orders WHERE order_date >= NOW() - INTERVAL '6 months' " + "  AND status != 'CANCELLED' "
				+ "GROUP BY month, sort_key ORDER BY sort_key ASC";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				map.put(rs.getString("month"), rs.getDouble("revenue"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Integer> getOrderStatusCounts() {
		Map<String, Integer> map = new LinkedHashMap<>();
		String sql = "SELECT status, COUNT(*) AS cnt FROM orders GROUP BY status ORDER BY status";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				map.put(rs.getString("status"), rs.getInt("cnt"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public List<String[]> getTopProducts() {
		List<String[]> list = new ArrayList<>();
		String sql = "SELECT p.product_name, SUM(oi.quantity) AS total_sold, "
				+ "       SUM(oi.quantity * oi.price) AS revenue "
				+ "FROM order_items oi JOIN products p ON oi.product_id = p.product_id "
				+ "GROUP BY p.product_name ORDER BY total_sold DESC LIMIT 5";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				list.add(new String[] { rs.getString("product_name"), rs.getString("total_sold"),
						rs.getString("revenue") });
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Map<String, Double> getRevenueByCategory() {
		Map<String, Double> map = new LinkedHashMap<>();
		String sql = "SELECT c.category_name, COALESCE(SUM(oi.quantity * oi.price),0) AS revenue "
				+ "FROM order_items oi " + "JOIN products p   ON oi.product_id  = p.product_id "
				+ "JOIN categories c ON p.category_id  = c.category_id "
				+ "GROUP BY c.category_name ORDER BY revenue DESC";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next())
				map.put(rs.getString("category_name"), rs.getDouble("revenue"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public List<String[]> getLowStockProducts(int threshold) {
		List<String[]> list = new ArrayList<>();
		String sql = "SELECT product_name, stock_quantity FROM products "
				+ "WHERE stock_quantity <= ? ORDER BY stock_quantity ASC";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, threshold);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				list.add(new String[] { rs.getString("product_name"), rs.getString("stock_quantity") });
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