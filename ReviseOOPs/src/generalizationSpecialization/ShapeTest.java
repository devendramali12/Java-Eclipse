package generalizationSpecialization;

// --> Parent class

class shape {
	// --> Method to be overridden
	void draw() {
		System.out.println("Drawing a Shape");
	}
}

// --> Child class

class circle extends shape {
	// --> Overriding draw method
	void draw() {
		System.out.println("Drawing a Circle");
	}
}

// --> Child class
class rectangle extends shape {
	// --> Overriding draw method
	void draw() {
		System.out.println("Drawing a Rectangle");
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		// --> Generalized reference , specialized object
		shape s1 = new circle();
		shape s2 = new rectangle();

		// --> Run-Time Polymorphism
		s1.draw();
		s2.draw();
	}

}
