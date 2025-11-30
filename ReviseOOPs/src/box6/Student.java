package box6;

public class Student {

	String name; // --> Non-Static Global Variable
	int age;

	// No-Argument Constructor
	Student() {
		name = "unkwon";
		age = 0;
		System.out.println("No-Argument Constructor");

	}

	void display() {
		System.out.println("Name :- " + name + " Age :- " + age);
	}

}
