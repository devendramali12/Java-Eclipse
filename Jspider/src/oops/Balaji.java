package oops;

public class Balaji {
	public static void main(String[] args) {
		AlooBhujiya a1 = new AlooBhujiya();
		System.out.println(a1.price);
		System.out.println(a1.size);
		System.out.println(a1.weight);
		a1.khabar();

		System.out.println();
		System.out.println();

		AlooBhujiya a2 = new AlooBhujiya();
		a2.price = 20;
		a2.size = "Small";
		a2.weight = 200.00;
		System.out.println(a2.price);
		System.out.println(a2.size);
		System.out.println(a2.weight);
		a2.khabar();

		System.out.println();
		System.out.println();

		CreamAndOnion c1 = new CreamAndOnion();
		System.out.println(c1.falvour);
		System.out.println(c1.price);
		System.out.println(c1.weight);
		c1.details();

		c1.falvour = "Tasty";
		c1.price = 20;
		c1.weight = 125.00;

		System.out.println();
		System.out.println();
		c1.details();

	}

}
