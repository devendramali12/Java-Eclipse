package interfaces;

interface animal {
	void eat();

	void sleep();

	void sound();
}

class cat implements animal {

	@Override
	public void eat() {
		System.out.println("Cat Drink Milk");
		// TODO Auto-generated method stub

	}

	@Override
	public void sleep() {
		System.out.println("Cat is Sleeping");

		// TODO Auto-generated method stub

	}

	@Override
	public void sound() {
		System.out.println("Cat Sounds Meow Meow");
		// TODO Auto-generated method stub

	}

}

class tiger implements animal {

	@Override
	public void eat() {
		System.out.println("Tiger Eat Non-Veg");
		// TODO Auto-generated method stub

	}

	@Override
	public void sleep() {
		System.out.println("Tiger Sleep At Night");
		// TODO Auto-generated method stub

	}

	@Override
	public void sound() {
		System.out.println("Tiger Roarss");
		// TODO Auto-generated method stub

	}

}

public class Jungle {
	public static void main(String[] args) {
		animal a1 = new cat();
		a1.eat();
		a1.sleep();
		a1.sound();
	}

}
