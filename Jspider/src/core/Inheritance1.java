package core;

class dad {

	void land() {
		System.out.println("50-Acres Land");
	}

	static void ghar() {
		System.out.println("4-BHK");
	}
}

class son extends dad {

}

public class Inheritance1 {
	public static void main(String[] args) {
		son s1 = new son();

		son.ghar();
		s1.land();
	}

}
