package constructor;

class Earphone {
	String brand;
	int price;
	String shape;

	// No-Argument Constructor

	Earphone() {
		brand = "OnePlus";
		price = 2999;
		shape = "Recentangle";

	}

	void info() {
		System.out.println("Earphone Brand Is :- " + brand + " Its Price is " + price + " Shape is:-  " + shape);

	}
}

public class TWS {
	public static void main(String[] args) {
		Earphone t1 = new Earphone();

		t1.info();
	}

}
