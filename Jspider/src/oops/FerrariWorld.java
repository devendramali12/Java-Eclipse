package oops;

class Ferrari {
	String color = "Red";
	int speed = 250;
	int hp = 400;

	void info() {
		System.out.println("Car Color :- " + color + " Speed :- " + speed + " HoursePower is :- " + hp);

	}

}

public class FerrariWorld {
	public static void main(String[] args) {
		System.out.println("FW Start");

		Ferrari f1 = new Ferrari();
		Ferrari f2 = new Ferrari();
		Ferrari f3 = new Ferrari();

		f1.color = "Pink"; // Color:- Red --> Pink in f1 method
		f2.speed = 450; // Speed 250 --> 450 in f1 method
		f3.hp = 2000; // HP 400 --> 2000

		f1.info();
		f2.info();
		f3.info();

		System.out.println("FW End");

	}

}
