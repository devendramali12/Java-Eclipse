package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DBConnection;

/**
 * UserDAO.java ─────────────────────────────────────────────────────────────
 * Data Access Object — all DB operations for the users table. Location :
 * src/main/java/dao/UserDAO.java
 * ───────────────────────────────────────────────────────────── Uses
 * PreparedStatement throughout to prevent SQL injection.
 */
public class UserDAO {

	// ── Register New User ───────────────────────────────────────────────
	/**
	 * Inserts a new user row. Returns false if the email already exists.
	 */
	public boolean registerUser(User user) {
		String sql = "INSERT INTO users (name, email, password, phone) " + "VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword()); // Hash with BCrypt in production!
			ps.setString(4, user.getPhone());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			// PostgreSQL unique-violation code = 23505
			if ("23505".equals(e.getSQLState()))
				return false;
			e.printStackTrace();
			return false;
		}
	}

	// ── Validate Login ──────────────────────────────────────────────────
	/**
	 * Returns the User if credentials match, otherwise null.
	 */
	public User loginUser(String email, String password) {
		String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, email);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User u = new User();
					u.setId(rs.getInt("id"));
					u.setName(rs.getString("name"));
					u.setEmail(rs.getString("email"));
					u.setPhone(rs.getString("phone"));
					return u;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ── Check Duplicate Email ───────────────────────────────────────────
	public boolean emailExists(String email) {
		String sql = "SELECT id FROM users WHERE email = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}