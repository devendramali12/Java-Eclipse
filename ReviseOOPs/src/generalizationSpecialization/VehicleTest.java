package generalizationSpecialization;

class vehicle {
	void start() {
		System.out.println("Vehicle is starting");
	}
}

class car extends vehicle {
	void drive() {
		System.out.println("Car Is Driving");
	}
}

class bike extends vehicle {
	void ride() {
		System.out.println("Bike Is Riding");
	}
}

public class VehicleTest {
	public static void main(String[] args) {
		car c = new car();
		c.start(); // --> Inherited (Generalized )
		c.drive(); // --> Specialized

		System.out.println("--------------------------");
		bike b1 = new bike();
		b1.start(); // --> Inherited
		b1.ride(); // --> Specialized
	}

}
