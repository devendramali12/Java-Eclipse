package box7;

class Animals {
	void eat() {
		System.out.println("Animal Is Eating.........");
	}
}

// --> Child 1

class dog extends Animals {
	void bark() {
		System.out.println("Dog Is Barking..........");
	}
}

// --> Child 2 
class cat extends Animals {
	void meow() {
		System.out.println("Cat is Meowing.......");
	}
}

public class Hierarchical {
	public static void main(String[] args) {
		dog d = new dog();
		d.eat();
		d.bark();

		System.out.println("------------------------------------------");

		cat c = new cat();
		c.eat();
		c.meow();
	}

}
