package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.model.User;
import com.shop.util.DBConnection;

public class UserDAO {

	public User authenticate(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean registerUser(User user) {
		if (isUsernameTaken(user.getUsername()) || isEmailTaken(user.getEmail()))
			return false;
		String sql = "INSERT INTO users (username, email, password, full_name, phone, address) VALUES (?,?,?,?,?,?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
		return u;
	}
}