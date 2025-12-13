package box9;

class stud {

	String name;
	int roll;
	char div;
	int age;
	double height;

	stud() {
		System.out.println("No-Argument Constructor");
	}

	stud(String name) {
		this();
		this.name = name;
		System.out.println("One para");
	}

	stud(String name, int roll) {
//		this.name = name;
		this(name);
		this.roll = roll;
		System.out.println("Two Para");
	}

	stud(String name, int roll, char div) {
		this(name, roll);
		this.div = div;
		System.out.println("Three Para");

	}

	stud(String name, int roll, char div, int age) {
		this(name, roll, div);
		this.age = age;
		System.out.println("Four Para");
	}

	stud(String name, int roll, char div, int age, double height) {
		this(name, roll, div, age);
		this.height = height;
		System.out.println("Five Para");
	}
}

public class Lala {
	public static void main(String[] args) {
		stud s1 = new stud("Devendra", 22, 'A', 12, 6.5);

	}

}
