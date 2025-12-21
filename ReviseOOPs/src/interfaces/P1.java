package interfaces;

class animalss {
	void eat() {
		System.out.println("all animals eat");

	}

	void drink() {
		System.out.println("All Animlas Eats");
	}

}

class caat extends animalss {
	@Override
	void eat() {
		System.out.println("Cat Eats Mouse");
	}

	@Override
	void drink() {
		System.out.println("Cat Drink Milk");
	}
}

class doggy extends animalss {
	@Override
	void eat() {
		System.out.println("Dog Eats Non-Veg");
	}

	@Override
	void drink() {
		System.out.println("Dog Drinks Milk");
	}
}

public class P1 {
	public static void main(String[] args) {

		doggy d1 = new doggy();
		d1.drink();
		d1.eat();
	}

}
