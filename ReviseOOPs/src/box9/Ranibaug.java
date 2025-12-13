package box9;

class Animal {
	void eat() {
		System.out.println("All Animal Eats");

	}

	void sleep() {
		System.out.println("All Animal Sleeps");
	}

	void breadth() {
		System.out.println("All Animal Breadth");
	}

	void sound() {
		System.out.println("All Animal Makes Sound");
	}
}

class dog extends Animal {
	@Override
	void sound() {
		System.out.println("Baww Baww");
	}

}

class cat extends Animal {
	void eat() {
		System.out.println("Dudu Pasand Hai");
	}
}

public class Ranibaug {
	public static void main(String[] args) {

		Animal a1 = new Animal();
		a1.breadth();
		a1.sound();
		System.out.println("---------------------------------------");

		dog d1 = new dog();
		d1.sound();
		d1.eat();

		System.out.println("---------------------------------------");

		cat c1 = new cat();
		c1.eat();
		c1.breadth();

	}

}
