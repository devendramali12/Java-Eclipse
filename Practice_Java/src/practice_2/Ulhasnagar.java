package practice_2;

public class Ulhasnagar {
	public static void main(String[] args) {
		System.out.println(new Thane().age);
		System.out.println(new Thane().name);

		new Thane().display();

		System.out.println("-----------------------------------");

		Thane t1 = new Thane();
		t1.age = 25;
		t1.name = "Aditya";
		System.out.println(t1.age);
		System.out.println(t1.name);
		t1.display();

		System.out.println("--------------------------------------");
		Thane t2 = new Thane("Aamisha", 21);
		System.out.println(t2.name);
		System.out.println(t2.age);
		t2.display();

		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println(Thane.fees);
		System.out.println(Thane.str);

		Thane.info();

	}
}
