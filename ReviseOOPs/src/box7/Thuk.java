package box7;

public class Thuk {

	static String brand; // --> Static Global Variable
	int price; // --> Non-Static Variable

	// --> Non-Static Block 1
	{
		System.out.println("B-- Non Static Block");
		price = 25;
	}

	// --> Constructor
	Thuk() {
		brand = "RupaBedi";
		price = 8;
		System.out.println("Thuk Constructor...");

	}

	public static void main(String[] args) {
		System.out.println("Main Start");

		Thuk t1 = new Thuk(); // --> Object 1
		System.out.println(t1.brand);
		System.out.println(t1.price);

		System.out.println("---------------------------------------------");

		Thuk t2 = new Thuk(); // --> Object 2

		System.out.println("---------------------------------------------");

		Thuk t3 = new Thuk(); // --> Object 3

		System.out.println("---------------------------------------------");

		System.out.println("Main End");

	}

	// --> Static Block 2
	static {
		System.out.println("E--Inside Static Block 2");
		brand = "Gaichaap";
	}

	// --> Non-Static Block 2
	{
		System.out.println("F Non-Static Block 2");
		price = 10;
	}

}
