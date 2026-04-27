package box7;

class ani {
	void sound() {
		System.out.println("Every Animal Makes Sound");
	}

	void eat() {
		System.out.println("Every Animal eat's");
	}
}

class cats extends ani {
	@Override
	void sound() {
		System.out.println("Meow meow");
	}

	@Override
	void eat() {
		System.out.println("Cat Eats Mouse");
	}

}

class dogesh extends ani {
	@Override
	void sound() {
		System.out.println("Bhaw Bhaw");
	}

	@Override
	void eat() {
		System.out.println("Eats Chicken");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		ani a1 = new cats();
		a1.eat();
		a1.sound();

		ani a2 = new dogesh();
		a2.sound();
		a2.eat();
	}

}
