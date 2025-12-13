package box9;

class student {
	String name;
	int age;
	char gen;

	student(String name, int age, char gen) {
		this.name = name;
		this.age = age;
		this.gen = gen;
	}
}

class person extends student {

	int id;
	double sal;

	person(int id, double sal, String name, int age, char gen) {
		super(name, age, gen);
		this.id = id;
		this.sal = sal;
		System.out.println("Constructor Chaining");

	}

}

public class Diwali {

	public static void main(String[] args) {
		person p1 = new person(12, 25.36, "Devendra", 12, 'm');
	}
}
