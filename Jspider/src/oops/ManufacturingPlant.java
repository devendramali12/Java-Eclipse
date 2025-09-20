package oops;

public class ManufacturingPlant {
	public static void main(String[] args) {
		System.out.println("Main Start");

		Defender d1 = new Defender();
		System.out.println(d1.colour);
		System.out.println(d1.speed);
		System.out.println(d1.mil);

		// We Can Access All The Attribute / Variables easily using Method

		d1.info();
		System.out.println("------------------------------------");
		Defender d2 = new Defender();
		d2.info();

		System.out.println("-------------------------------------");

		d1.colour = "Bhagwa";
		d1.speed = 120;
		d1.mil = 6.8;

		d2.colour = "Black";
		d2.speed = 270;
		d2.mil = 3.5;

		d1.info();
		d2.info();
		System.out.println("Main End");

	}

}
