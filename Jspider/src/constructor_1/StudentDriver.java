package constructor_1;

public class StudentDriver {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student("Smith");
		Student s3 = new Student("Ram", 21);

		s1.display();
		s2.display();
		s3.display();

	}
}
