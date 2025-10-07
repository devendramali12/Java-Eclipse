package practice_2;

public class Thane {
	static String str = "JSpider";
	static int fees = 25000;

	static void info() {
		System.out.println("Class Name is " + str + " Fees is :- " + fees);
	}

	String name = "Devendra";
	int age = 18;

	Thane() {
		System.out.println("No-Argument Constructor called...");
	}

	Thane(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void display() {
		System.out.println("Name :- " + name + " Age :- " + age);

	}

}
