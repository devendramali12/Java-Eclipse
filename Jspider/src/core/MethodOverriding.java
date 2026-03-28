package core;

class Animal {
	void eat() {
		System.out.println("All Animal Eats");
	}

	void sleep() {
		System.out.println("All Animal Sleep");
	}

}

class cat extends Animal {
	@Override
	void eat() {
		System.out.println("Cat Eats Mouse");
	}

	@Override
	void sleep() {
		System.out.println("Cat is Sleeping");
	}
}

public class MethodOverriding {
	public static void main(String[] args) {

		Animal a1 = new Animal();
		a1.eat();
		a1.sleep();

		System.out.println("-------------------------------------------------------------------------");

		cat c1 = new cat();
		c1.eat();
		c1.sleep();
	}

}
