package oops;

class Nanoo {
	String color = "Blue";
	int speed = 100;

	void deatils() {

		System.out.println("Car Color is " + color + " Speed is :- " + speed);
	}

}

public class Tata1 {
	public static void main(String[] args) {
		System.out.println("Main Start");
		Nanoo n1 = new Nanoo(); // Object 1
		Nanoo n2 = new Nanoo(); // Object 2
		Nanoo n3 = new Nanoo(); // Object 3

		System.out.println(n1); // Address Of Reference Variable n1
		System.out.println(n2); // --||-- n2
		System.out.println(n3); // -- ||-- n3

		n1.color = "red";
		n2.speed = 120;

		System.out.println(n1.color); // Blue --> Red
		System.out.println(n1.speed);// 100

		System.out.println("----------------------------");
		System.out.println(n2.color); // blue
		System.out.println(n2.speed); // 100 --> 120

		System.out.println("------------------------------");
		System.out.println(n3.color); // Blue
		System.out.println(n3.speed); // 100
		System.out.println("Main end");

	}

}
