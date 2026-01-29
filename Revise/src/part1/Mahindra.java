package part1;

class Thar {
	String s;
	int price;

	// --> Default Constructor
	Thar() {
		System.out.println("Default Constructor");
	}

	// --> Parametrized Constructor
	Thar(String s, int price) {
		this.s = s;
		this.price = price;
	}

	void info() {
		System.out.println("Thar Color is " + s + " Price is " + price);
	}
}

public class Mahindra {
	public static void main(String[] args) {

		Thar t1 = new Thar();
		t1.info();

		System.out.println("-------------------------------------");

		Thar t2 = new Thar("Pink", 250);
		t2.info();
	}
}
