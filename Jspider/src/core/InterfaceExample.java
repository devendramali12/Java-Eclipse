package core;

interface vehicle {
	void start();

	void stop();

}

class Bike implements vehicle {

	@Override
	public void start() {
		System.out.println("Bike Starts With Kick");
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		System.out.println("Bike Stops Using Brake");
		// TODO Auto-generated method stub

	}

}

class car implements vehicle {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("car Starts With key");

	}

	@Override
	public void stop() {
		System.out.println("Car Stops using brake");
		// TODO Auto-generated method stub

	}

}

public class InterfaceExample {
	public static void main(String[] args) {
		vehicle v1 = new Bike();// --> Up-casting
		v1.start();
		v1.stop();

		System.out.println("-----------------------");

		vehicle v2 = new car(); // --> Up-casting
		v2.start();
		v2.stop();

	}

}
