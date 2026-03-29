package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import util.DBConnection;

/**
 * BookingDAO.java ─────────────────────────────────────────────────────────────
 * Data Access Object — all DB operations for the bookings table. Location :
 * src/main/java/dao/BookingDAO.java
 */
public class BookingDAO {

	// ── Internal Helper: ResultSet → Booking ───────────────────────────
	private Booking mapRow(ResultSet rs) throws SQLException {
		Booking b = new Booking();
		b.setId(rs.getInt("id"));
		b.setUserId(rs.getInt("user_id"));
		b.setPackageId(rs.getInt("package_id"));
		b.setBookingDate(rs.getDate("booking_date"));
		b.setPeople(rs.getInt("people"));
		// Joined fields — safe to silently ignore if not in SELECT
		try {
			b.setUserName(rs.getString("user_name"));
		} catch (SQLException ignored) {
		}
		try {
			b.setPackageName(rs.getString("package_name"));
		} catch (SQLException ignored) {
		}
		try {
			b.setLocation(rs.getString("location"));
		} catch (SQLException ignored) {
		}
		return b;
	}

	// ── Create a New Booking ────────────────────────────────────────────
	public boolean createBooking(Booking booking) {
		String sql = "INSERT INTO bookings (user_id, package_id, booking_date, people) " + "VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, booking.getUserId());
			ps.setInt(2, booking.getPackageId());
			ps.setDate(3, booking.getBookingDate());
			ps.setInt(4, booking.getPeople());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ── Get Bookings for a Specific User ────────────────────────────────
	public List<Booking> getBookingsByUser(int userId) {
		List<Booking> list = new ArrayList<>();
		String sql = "SELECT b.*, u.name AS user_name, p.package_name, p.location " + "FROM bookings b "
				+ "JOIN users    u ON b.user_id    = u.id " + "JOIN packages p ON b.package_id = p.id "
				+ "WHERE b.user_id = ? " + "ORDER BY b.booking_date DESC";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next())
					list.add(mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// ── Get All Bookings (Admin View) ───────────────────────────────────
	public List<Booking> getAllBookings() {
		List<Booking> list = new ArrayList<>();
		String sql = "SELECT b.*, u.name AS user_name, p.package_name, p.location " + "FROM bookings b "
				+ "JOIN users    u ON b.user_id    = u.id " + "JOIN packages p ON b.package_id = p.id "
				+ "ORDER BY b.booking_date DESC";

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

	// ── Delete Booking ──────────────────────────────────────────────────
	public boolean deleteBooking(int id) {
		String sql = "DELETE FROM bookings WHERE id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}