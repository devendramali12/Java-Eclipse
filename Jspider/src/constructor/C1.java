package constructor;

class Balaji {
	String name;
	int age;
	// No-Argument Constructor

	Balaji() {
		System.out.println("No Argument Constructor called !!");
		name = "Devendra";
		age = 22;
	}

	void info() {
		System.out.println("Name " + name + "  Age " + age);
	}

}

public class C1 {

	public static void main(String[] args) {
		Balaji b1 = new Balaji();
		System.out.println(b1);
		System.out.println(b1.age);
		System.out.println(b1.name);

		System.out.println();
		System.out.println();

		Balaji b2 = new Balaji();
		System.out.println(b2);
		b2.info();
	}

}
