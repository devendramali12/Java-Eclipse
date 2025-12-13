package typecasting;

class Animal1 {
	void eat() {
		System.out.println("Animal Eats");
	}
}

class cat1 extends Animal1 {
	@Override
	void eat() {
		System.out.println("Cats Eats Fish");
	}
}

public class Upcasting2 {
	static void display(Animal1 a) {
		a.eat();
	}

	public static void main(String[] args) {
		cat1 c1 = new cat1();
		display(c1); // Upcasting Cat --> Animal
	}

}
