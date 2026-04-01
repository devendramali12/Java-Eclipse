package core;

class animal {
	void eat() {
		System.out.println("All Animals Eats");
	}

	void drink() {
		System.out.println("All Animals Drink");
	}
}

class catt extends animal {
	@Override
	void eat() {
		System.out.println("Cat Eats Mouse");
	}

	@Override
	void drink() {
		System.out.println("Cat drink milk");
	}
}

class dogesh extends animal {
	@Override
	void eat() {
		System.out.println("Dog Eats Non-veg");
	}

	@Override
	void drink() {
		System.out.println("Dog drink water");
	}
}

public class RunTimePolymorphism {
	public static void main(String[] args) {
		animal a1 = new dogesh();
		a1.eat();
		a1.drink();

		System.out.println("---------------------------------------------------");

		animal a2 = new catt();
		a2.drink();
		a2.eat();

	}

}
