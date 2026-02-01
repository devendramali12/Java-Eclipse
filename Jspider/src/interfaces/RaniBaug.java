package interfaces;

interface animal {
	void eat();

	void sleep();

	void sound();
}

class fourlegs {
	void legs() {
		System.out.println("This animal Has 4 Legs");
	}
}

class cat extends fourlegs implements animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cat Eats Mouse");

	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Cat Is Sleeping");

	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Cat Sounds Meow Meow");

	}

}

public class RaniBaug {
	public static void main(String[] args) {
		cat c1 = new cat();
		c1.eat();
		c1.sleep();
		c1.sound();
		c1.legs();
	}

}
