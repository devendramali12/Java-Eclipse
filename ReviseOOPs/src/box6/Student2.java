package box6;

public class Student2 {
	String name;
	int age;

	// --> No-Arg Constructor

	Student2() {
		name = "Unknown";
		age = 0;

	}
	// --> Parameterized Constructor (1 Parameter)

	Student2(String name) {
		this.name = name;
	}

	// --> Parameterized Constructor (2 Parameter)

	Student2(String name, int age) {

		this.name = name;
		this.age = age;
	}

	void display() {
		System.out.println("Name:- " + name + " Age:- " + age);
	}
}
