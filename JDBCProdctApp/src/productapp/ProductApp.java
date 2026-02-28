package productapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductApp {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "admin";

		try {
			// 1.Load driver (Optional in modern JDBC)
			Class.forName("org.postgresql.Driver");

			// 2. Create connection
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgreSQL !");

			// 3.Create Statement
			Statement stmt = con.createStatement();

			// 4. Execute Query
			String query = "SELECT* FROM product";
			ResultSet rs = stmt.executeQuery(query);

			// 5. Process result

			while (rs.next()) {
				System.out.println(rs.getInt("product_id") + " | " + rs.getString("product_name") + " | "
						+ rs.getString("category") + " | " + rs.getBigDecimal("price") + " | " + rs.getInt("stock")
						+ " | " + rs.getDate("created_at")

				);
			}
			// 6.Close Connection
			rs.close();
			stmt.close();
			con.close();
			System.out.println("Connection Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
