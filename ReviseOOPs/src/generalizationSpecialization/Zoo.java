package generalizationSpecialization;

// --> Parent Class

class animal {
	// --> Common Method
	void eat() {
		System.out.println("Animal eats food");
	}
}

// --> Child class
class dog extends animal {
	// --> Dog-Specific Behavior
	void bark() {
		System.out.println("Dog Barks");
	}
}

// Child Class
class cat extends animal {
	// --> Cat-Specific Behavior
	void meow() {
		System.out.println("Cat Meow");
	}
}

// --> Main Class
public class Zoo {
	public static void main(String[] args) {
		dog d1 = new dog();
		d1.eat();
		d1.bark();

		cat c1 = new cat();
		c1.eat();
		c1.meow();
	}
}
