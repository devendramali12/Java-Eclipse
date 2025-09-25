package constructor;

class car {
	String Brand;
	int price;

	// Parameterized Constructor
	car(String s, int p) {
		Brand = s;
		price = p;
	}

	void details() {
		System.out.println("Car Barnd is " + Brand + " And Price is " + price);
	}
}

public class CarDriver {
	public static void main(String[] args) {
		car c1 = new car("Audi", 850000);
		c1.details();

		car c2 = new car("Mercedes Benz", 950000000);
		c2.details();
	}

}
