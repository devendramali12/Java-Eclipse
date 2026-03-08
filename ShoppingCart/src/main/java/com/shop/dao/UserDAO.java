package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.shop.model.User;
import com.shop.util.DBConnection;

public class UserDAO {

	// Authenticate with BCrypt
	public User authenticate(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					String hashed = rs.getString("password");
					if (BCrypt.checkpw(password, hashed)) {
						return mapRow(rs);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Register with BCrypt
	public boolean registerUser(User user) {
		if (isUsernameTaken(user.getUsername()) || isEmailTaken(user.getEmail()))
			return false;
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
		String sql = "INSERT INTO users (username, email, password, full_name, phone, address) VALUES (?,?,?,?,?,?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, hashed);
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Update profile
	public boolean updateProfile(User user) {
		String sql = "UPDATE users SET full_name=?, phone=?, address=? WHERE user_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getAddress());
			ps.setInt(4, user.getUserId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Change password
	public boolean changePassword(int userId, String oldPassword, String newPassword) {
		String sql = "SELECT password FROM users WHERE user_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String hashed = rs.getString("password");
				if (!BCrypt.checkpw(oldPassword, hashed))
					return false;
				String newHashed = BCrypt.hashpw(newPassword, BCrypt.gensalt(10));
				PreparedStatement upd = conn.prepareStatement("UPDATE users SET password=? WHERE user_id=?");
				upd.setString(1, newHashed);
				upd.setInt(2, userId);
				return upd.executeUpdate() > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Get user by ID
	public User getUserById(int userId) {
		String sql = "SELECT * FROM users WHERE user_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Get all users (for admin)
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<>();
		String sql = "SELECT * FROM users ORDER BY user_id";
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

	private boolean isUsernameTaken(String username) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM users WHERE username=?")) {
			ps.setString(1, username);
			return ps.executeQuery().next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isEmailTaken(String email) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM users WHERE email=?")) {
			ps.setString(1, email);
			return ps.executeQuery().next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private User mapRow(ResultSet rs) throws SQLException {
		User u = new User();
		u.setUserId(rs.getInt("user_id"));
		u.setUsername(rs.getString("username"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		u.setFullName(rs.getString("full_name"));
		u.setPhone(rs.getString("phone"));
		u.setAddress(rs.getString("address"));
		u.setAdmin(rs.getBoolean("is_admin"));
		return u;
	}
}