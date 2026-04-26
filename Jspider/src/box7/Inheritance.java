package box7;

class Animal {
	void eat() {
		System.out.println("All Animals Eats");
	}

	void sleep() {
		System.out.println("All Animal Sleep");
	}

	void sound() {
		System.out.println("All Animlas Makes Sound");
	}
}

class Cat extends Animal {

}

public class Inheritance {
	public static void main(String[] args) {
		Cat c1 = new Cat();
		c1.eat();
		c1.sleep();
		c1.sound();
	}

}
