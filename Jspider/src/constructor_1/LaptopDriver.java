package constructor_1;

public class LaptopDriver {
	public static void main(String[] args) {
		Laptop l1 = new Laptop("HP", "i5", 16, 4500);
		Laptop l2 = new Laptop("Dell", "i7", 16, 4500);

		l1.display();
		l2.display();
	}

}
