package abstraction;

interface Animal {
	void sound();
}

class dog implements Animal {
	public void sound() {
		System.out.println("bow bow");
	}
}

public class Test {
	public static void main(String[] args) {
		Animal a = new dog();
		a.sound();
	}

}
