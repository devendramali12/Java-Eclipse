package practice_2;

public class Bike {
	String name;
	int price;

	Bike() {
		name = "Splender";
		price = 150;
		System.out.println("No Argument Constructor Called");
	}

	Bike(String name, int price) {
		this.name = name;
		this.price = price;

	}

	void deatils() {
		System.out.println("Bike Name is " + name + " Price is " + price);
	}

}
