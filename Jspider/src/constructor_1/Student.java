package constructor_1;

public class Student {
	String name;
	int age;

	// No Argument Constructor

	Student() {
		name = "Unkonwn";
		age = 0;

	}
	// Parameterized Constructor( 1 Parameter )

	Student(String name) {
		this.name = name;
		age = 0;
	}
	// Parameterized Constructor( 2 Parameter )

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void display() {
		System.out.println("Name :- " + name + " Age :- " + age);
	}

}
