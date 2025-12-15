package abstraction;

class ddlj { // --> Concrete class
	void dance() { // --> Concrete Method
		System.out.println("Lavni");
	}

}

abstract class conjurring {
	abstract void jump(); // --> abstract class

	void swim() { // --> Concrete Class
		System.out.println("FreeStyle Swmming");
	}
}

public class Filmy {
	public static void main(String[] args) {
		ddlj d1 = new ddlj();
		d1.dance();

		// --> We Can't create object of abstract class
	}

}
