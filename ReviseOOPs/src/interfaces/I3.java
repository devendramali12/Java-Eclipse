package interfaces;

interface vehicle {
	void start();

	default void fuel() {
		System.out.println("Uses Petrol Or Diesel");
	}
}

class car implements vehicle {
	public void start() {
		System.out.println("Car Starts With Key");
	}
}

public class I3 {
	public static void main(String[] args) {
		vehicle v1 = new car();
		v1.start();
		v1.fuel();
	}

}
