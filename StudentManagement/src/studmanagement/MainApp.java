package studmanagement;

import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();

		while (true) {
			System.out.println("\n--- Student Management ---");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");

			System.out.print("Choose option: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Email: ");
				String email = sc.nextLine();

				System.out.print("Enter Course: ");
				String course = sc.nextLine();

				dao.addStudent(new Student(name, email, course));
				break;

			case 2:
				List<Student> list = dao.getAllStudents();
				for (Student s : list) {
					System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail() + " | " + s.getCourse());
				}
				break;

			case 3:
				System.out.print("Enter ID to update: ");
				int uid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new course: ");
				String newCourse = sc.nextLine();

				dao.updateStudent(uid, newCourse);
				break;

			case 4:
				System.out.print("Enter ID to delete: ");
				int did = sc.nextInt();
				dao.deleteStudent(did);
				break;

			case 5:
				System.out.println("Exiting...");
				System.exit(0);

			default:
				System.out.println("Invalid choice!");
			}
//			sc.close();
		}
	}
}
