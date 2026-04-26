package box7;

class Engine {
	void start() {
		System.out.println("Engine Started......");
	}
}

class car {
	private Engine engine; // --> HAS-A relationship

	// Constructor
	car() {
		engine = new Engine(); // Car Creates Engine
	}

	void drive() {
		engine.start();
		System.out.println("Car Is Moving...");
	}
}

public class Test3 {
	public static void main(String[] args) {
		car c = new car();
		c.drive();
	}

}
