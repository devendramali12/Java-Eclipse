package box5;

class Anjali {

	static int age = 18; // --> Static Global Variable

	static void greet() { // --> Static Method
		System.out.println("Namaste");
	}

}

public class Ajeet {
	public static void main(String[] args) {

		System.out.println(Anjali.age);
		Anjali.greet();
	}

}
