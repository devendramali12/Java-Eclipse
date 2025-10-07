package practice_2;

public class BikeDriver {
	public static void main(String[] args) {
		Bike b1 = new Bike();
		System.out.println(b1.name);
		System.out.println(b1.price);
		b1.deatils();

		System.out.println();
		System.out.println("---------------------------------------------------");

		Bike b2 = new Bike("Cycle", 250);
		System.out.println(b2.name);
		System.out.println(b2.price);
		b2.deatils();

		System.out.println("------------------------------------------------------");
		Bike b3 = new Bike();
		System.out.println(b3.name);
		System.out.println(b3.price);
		b3.deatils();

		System.out.println("-------------------------------------------------------");
		Bike b4 = new Bike("Tata", 100);
		System.out.println(b4.name);
		System.out.println(b4.price);
		b4.deatils();

	}

}
