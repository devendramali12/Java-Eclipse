package part1;

class Student {
	String name;
	int age;
	double height;
	String Course;
	char Gen;

	Student() {
		System.out.println("Default Constructor");
	}

	Student(String name) {
		this.name = name;
	}

	Student(String name, int age) {
		this(name);
		this.age = age;
	}

	Student(String name, int age, double height) {
		this(name, age);
		this.height = height;

	}

	Student(String name, int age, double height, String Course) {
		this(name, age, height);
		this.Course = Course;
	}

	Student(String name, int age, double height, String Course, char Gen) {
		this(name, age, height, Course);
		this.Gen = Gen;
	}

	void info() {
		System.out.println("Student name " + name + " Age is " + age + " Height is " + height + " Course is " + Course
				+ " Gender is " + Gen);
	}

}

public class StudentDriver {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.info();
		System.out.println("-----------------------------------------");

		Student s2 = new Student("Devendra", 22);
		s2.info();
		System.out.println("-----------------------------------------");

		Student s3 = new Student("Omkar", 22, 5.6);
		s3.info();
		System.out.println("-----------------------------------------");

		Student s4 = new Student("Lala", 25, 6.3, "MCA");
		s4.info();
		System.out.println("-----------------------------------------");

		Student s5 = new Student("bala", 22, 6.2, "MCA", 'M');
		s5.info();
		System.out.println("-----------------------------------------");
	}

}
