package constructor_1;

public class MobileDriver {
	public static void main(String[] args) {
		Mobile m1 = new Mobile();
		Mobile m2 = new Mobile("Samsumng", 4500);
		Mobile m3 = new Mobile("Realme");
		Mobile m4 = new Mobile(100);

		m1.display();
		m2.display();
		m3.display();
		m4.display();
	}

}
