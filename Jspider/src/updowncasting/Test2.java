package updowncasting;

class Vehicle {
	void start() {
		System.out.println("Vehicle is Starting");
	}
}

class Car extends Vehicle {
	@Override
	void start() {
		System.out.println("Car is started");
	}

	void fuel() {
		System.out.println("Car Uses Petrol");
	}
}

public class Test2 {
	public static void main(String[] args) {
		Vehicle v1 = new Car(); // --> Upcasting
		v1.start();

		Car c = (Car) v1; // --> Downcasting
		c.start();
		c.fuel();
	}
}
