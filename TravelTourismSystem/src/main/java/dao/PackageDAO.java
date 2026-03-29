package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TravelPackage;
import util.DBConnection;

/**
 * PackageDAO.java ─────────────────────────────────────────────────────────────
 * Data Access Object — all DB operations for the packages table. Location :
 * src/main/java/dao/PackageDAO.java
 */
public class PackageDAO {

	// ── Internal Helper: ResultSet → TravelPackage ──────────────────────
	private TravelPackage mapRow(ResultSet rs) throws SQLException {
		TravelPackage p = new TravelPackage();
		p.setId(rs.getInt("id"));
		p.setPackageName(rs.getString("package_name"));
		p.setLocation(rs.getString("location"));
		p.setPrice(rs.getBigDecimal("price"));
		p.setDuration(rs.getString("duration"));
		p.setDescription(rs.getString("description"));
		p.setImageUrl(rs.getString("image_url"));
		return p;
	}

	// ── Get All Packages ────────────────────────────────────────────────
	public List<TravelPackage> getAllPackages() {
		List<TravelPackage> list = new ArrayList<>();
		String sql = "SELECT * FROM packages ORDER BY id ASC";

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

	// ── Get Single Package by ID ────────────────────────────────────────
	public TravelPackage getPackageById(int id) {
		String sql = "SELECT * FROM packages WHERE id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ── Search Packages (by name or location) ──────────────────────────
	public List<TravelPackage> searchPackages(String keyword) {
		List<TravelPackage> list = new ArrayList<>();
		String sql = "SELECT * FROM packages " + "WHERE LOWER(package_name) LIKE ? OR LOWER(location) LIKE ? "
				+ "ORDER BY id ASC";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			String kw = "%" + keyword.toLowerCase() + "%";
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

	// ── Add New Package (Admin) ─────────────────────────────────────────
	public boolean addPackage(TravelPackage pkg) {
		String sql = "INSERT INTO packages " + "(package_name, location, price, duration, description, image_url) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, pkg.getPackageName());
			ps.setString(2, pkg.getLocation());
			ps.setBigDecimal(3, pkg.getPrice());
			ps.setString(4, pkg.getDuration());
			ps.setString(5, pkg.getDescription());
			ps.setString(6, pkg.getImageUrl());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ── Update Existing Package (Admin) ────────────────────────────────
	public boolean updatePackage(TravelPackage pkg) {
		String sql = "UPDATE packages SET package_name=?, location=?, price=?, "
				+ "duration=?, description=?, image_url=? WHERE id=?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, pkg.getPackageName());
			ps.setString(2, pkg.getLocation());
			ps.setBigDecimal(3, pkg.getPrice());
			ps.setString(4, pkg.getDuration());
			ps.setString(5, pkg.getDescription());
			ps.setString(6, pkg.getImageUrl());
			ps.setInt(7, pkg.getId());
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ── Delete Package (Admin) ──────────────────────────────────────────
	public boolean deletePackage(int id) {
		String sql = "DELETE FROM packages WHERE id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}