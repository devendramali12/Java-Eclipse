package abstraction;

// --> Abstraction using Abstract Class
abstract class vehicle {
	abstract void start();

	void fueltype() {
		System.out.println("Uses Fuel");
	}
}

class car extends vehicle {
	@Override
	void start() {
		System.out.println("Car Starts With key");
	}
}

class bike extends vehicle {
	@Override
	void start() {
		System.out.println("Bike Start With Self Start");
	}
}

public class Abs1 {
	public static void main(String[] args) {
		vehicle v1 = new bike();
		vehicle v2 = new car();

		v1.start();
		v2.start();

	}

}
