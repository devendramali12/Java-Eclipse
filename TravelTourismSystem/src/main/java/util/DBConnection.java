package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection.java
 * ───────────────────────────────────────────────────────────── Utility class
 * that provides PostgreSQL JDBC connections.
 *
 * Location : src/main/java/util/DBConnection.java
 * ───────────────────────────────────────────────────────────── NOTE: The
 * PostgreSQL driver JAR is automatically downloaded by Maven — no manual
 * copying needed!
 */
public class DBConnection {

	// ── Database Configuration ──────────────────────────────────────────
	private static final String URL = "jdbc:postgresql://localhost:5432/travel_db";
	private static final String USER = "postgres";
	private static final String PASSWORD = "admin"; // ← Change this!
	private static final String DRIVER = "org.postgresql.Driver";

	/**
	 * Returns a new JDBC Connection to travel_db. Caller MUST close the connection
	 * (use try-with-resources).
	 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("PostgreSQL JDBC Driver not found. Check pom.xml dependency.", e);
		}
	}

	// Prevent instantiation
	private DBConnection() {
	}
}