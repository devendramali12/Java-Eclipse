package constructor_1;

public class Mobile {
	String brand;
	int price;

	Mobile() { // No Argument Constructor
		brand = "Iphone";
		price = 69000;

	}

	Mobile(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}

	Mobile(String brand) {
		this.brand = brand;

	}

	Mobile(int price) {
		this.price = price;
	}

	void display() {
		System.out.println("SmartPhone :- " + brand + " Price is :- " + price);
	}

}
