package polymorph;
/*
 * Method Overriding (Runtime Polymorphism)
Example: Parent reference → Child object
 */

class animal {
	void sound() {
		System.out.println("Animal Makes Sound");
	}
}

class dog extends animal {
	@Override
	void sound() {
		System.out.println("Baww Baww");
	}
}

class cat extends animal {
	@Override
	void sound() {
		System.out.println("Cat meoww");
	}
}

public class Test {
	public static void main(String[] args) {
		animal a1 = new dog();
		a1.sound();

		animal a2 = new cat();
		a2.sound();
	}

}
