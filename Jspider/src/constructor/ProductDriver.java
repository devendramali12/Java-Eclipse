package constructor;

public class ProductDriver {
	public static void main(String[] args) {
		Product p1 = new Product(5, "MARKER");
		System.out.println("P1 :" + p1);

		p1.info();

		Product p2 = new Product(4, "PEN");
		p2.info();

	}
}
