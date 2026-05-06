package updowncasting;

// --> parent Class 
class Animal {
	void sound() {
		System.out.println("Animal Makes Sound");
	}
}

// --> Child Class
class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("Dog Barks");
	}

	void eat() {
		System.out.println("Dog Eats Food");
	}
}

public class Test {
	public static void main(String[] args) {
		Animal a1 = new Dog(); // --> Upcasting
		a1.sound();
//		a1.eat();

		Dog d1 = (Dog) a1; // --> Downcasting
		d1.eat();
		d1.sound();

	}

}
