package box6;

class Nano {
	String color = "Blue";
	int speed = 100;

	void details() {
		System.out.println("Car Color is " + color + " Speed is " + speed);
	}
}

public class Tata {
	public static void main(String[] args) {

		Nano n1 = new Nano(); // --> Object 1
		Nano n2 = new Nano(); // --> Object 2
		Nano n3 = new Nano(); // --> Object 3

		// --> Object Address
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);

		System.out.println("--------------------------------------------------");

		n2.color = "Pink";
		n2.speed = 360;

		n3.color = "Yellow";
		n3.speed = 220;

		n1.details();
		n2.details();
		n3.details();

		System.out.println("--------------------------------------------------");

	}

}
