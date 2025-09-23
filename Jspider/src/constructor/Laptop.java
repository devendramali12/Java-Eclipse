package constructor;

class lap {
	String brand;
	int price;
	int ram;

	// No Argument Constructor
	lap() {

		brand = "HP";
		price = 50000;
		ram = 16;
	}

	void display() {
		System.out.println("LapTop Brand is :- " + brand + " And Price is :- " + price + " Its Having Ram :-" + ram);
	}

}

public class Laptop {
	public static void main(String[] args) {
		lap l1 = new lap();

		l1.display();

		lap l2 = new lap();
		l2.display();
	}

}
