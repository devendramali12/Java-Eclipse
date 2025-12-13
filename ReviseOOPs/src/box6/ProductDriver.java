package box6;

public class ProductDriver {
	public static void main(String[] args) {
		Product p1 = new Product(5, "Marker");

		System.out.println("P1 " + p1);
		p1.display();

		Product p2 = new Product(20, "Pen");
		p2.display();
	}

}
