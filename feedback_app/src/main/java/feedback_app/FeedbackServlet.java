package feedback_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String feedbackMessage = req.getParameter("feedback_message");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		try {

			Connection conn = DBConnection.getConnection();

			String sql = "INSERT INTO feedback (email, phone, message) VALUES (?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, phone);
			ps.setString(3, feedbackMessage);

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted > 0) {
				out.println("<h2 style='color:green;'>Feedback Saved Successfully!</h2>");
			} else {
				out.println("<h2 style='color:red;'>Failed to Save Feedback</h2>");
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
		}
	}
}