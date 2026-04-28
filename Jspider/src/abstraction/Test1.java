package abstraction;

abstract class vehicle {
	abstract void start(); // --> abstract method

	void fuel() {
		System.out.println("Fuel required");
	}
}

class car extends vehicle {
	void start() {
		System.out.println("start with key");
	}
}

public class Test1 {
	public static void main(String[] args) {
		vehicle v1 = new car();
		v1.start();
		v1.fuel();
	}

}
