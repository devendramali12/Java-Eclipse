package studmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	// Insert Student
	public void addStudent(Student student) {
		String sql = "INSERT INTO students(name,email,course)VALUES(?,?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCourse());

			ps.executeUpdate();
			System.out.println("Student added successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// View All Students
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT * FROM students";

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {

			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("course"));
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// Update Student
	public void updateStudent(int id, String course) {
		String sql = "UPDATE students SET course=? WHERE id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, course);
			ps.setInt(2, id);

			ps.executeUpdate();
			System.out.println("Student updated successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete Student
	public void deleteStudent(int id) {
		String sql = "DELETE FROM students WHERE id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Student deleted successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
