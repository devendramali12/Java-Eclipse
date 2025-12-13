package typecasting;

class Animal {
	void sound() {
		System.out.println("Animal Makes Sound");
	}
}

class dog extends Animal {
	@Override
	void sound() {
		System.out.println("Dog Barks");
	}

	void walk() {
		System.out.println("Dog is Walking");
	}
}

public class Upcasting1 {
	public static void main(String[] args) {
		Animal a1 = new dog(); // --> Upcasting

		a1.sound(); // Calls Dog's Methods (RunTime Polymorphism)
//		a1.walk(); --> Not Allowed
//  with upcasting, overridden method of child class runs.
	}

}
