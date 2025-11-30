package box6;

public class Student1 {
	String name;
	int age;

	// Parameterized Constructor

	Student1(String n, int a) {
		name = n;
		age = a;
		System.out.println("Parameterized Constructor Called");

	}

	void display() {
		System.out.println("Name: " + name + " Age: " + age);
	}

}
