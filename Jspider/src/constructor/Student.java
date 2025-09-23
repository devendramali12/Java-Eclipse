package constructor;

public class Student {
	String name;
	int age;
	// No-Argument Constructor

	Student() {
		name = "unkomwn";
		age = 0;
		System.out.println("No-arg Constructor Called..");

	}

	void display() {
		System.out.println("Name : " + name + " , Age :- " + age);
	}

}
