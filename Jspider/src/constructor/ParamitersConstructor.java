package constructor;

class student {
	String name;
	int age;

	// Parameterized Constructor

	student(String s, int n) {
		name = s;
		age = n;

	}

	void display() {
		System.out.println("Student Name is :- " + name + " Age is :- " + age);
	}

}

public class ParamitersConstructor {
	public static void main(String[] args) {
		student s1 = new student("Devendra", 22);
		s1.display();

		student s2 = new student("Ramesh", 21);
		s2.display();

	}

}
