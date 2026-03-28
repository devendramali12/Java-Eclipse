package core;

abstract class animals {

	abstract void sound();

	abstract void eat();

	abstract void sleep();

}

class catu extends animals {

	@Override
	void sound() {
		System.out.println("Meoww Meoww");
		// TODO Auto-generated method stub

	}

	@Override
	void eat() {
		System.out.println("Cat Eating Mouse");
		// TODO Auto-generated method stub

	}

	@Override
	void sleep() {
		System.out.println("Cat Loves Sleeping");
		// TODO Auto-generated method stub

	}

}

public class AbstractionExample {
	public static void main(String[] args) {
		animals a1 = new catu(); // Upcasting + Abstraction
		a1.eat();
		a1.sleep();
		a1.sound();

	}

}
