package com.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;

	static {
		// Use environment variables on Railway, fallback to local for Eclipse
		String envUrl = System.getenv("DB_URL");
		String envUser = System.getenv("DB_USER");
		String envPass = System.getenv("DB_PASS");

		URL = (envUrl != null) ? envUrl : "jdbc:postgresql://localhost:5432/shopping_cart_db";
		USERNAME = (envUser != null) ? envUser : "postgres";
		PASSWORD = (envPass != null) ? envPass : "admin";
	}

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("PostgreSQL Driver not found", e);
		}
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
//}```
//
//---
//
//##Step 3—Create.gitignore
//
//Create a`.gitignore`
//file in
//your project root if you don't
//have one:```target/*.class*.war.classpath.project.settings
///