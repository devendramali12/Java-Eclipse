package box7;

public class Panchayat {
	Panchayat() {
		System.out.println("C__ Inside Panchyat Constructor");
	}

	// --> Non-Static Block 1

	{
		System.out.println("A__ Aur Karo Meeting Meeting");

	}

	// --> Non-Static Block 2

	{
		System.out.println("B__ Gajab Bejati Hai");

	}

	public static void main(String[] args) {
		System.out.println("D__ Main Start");

		Panchayat p1 = new Panchayat(); // --> Object 1

		System.out.println("------------------------------------------------");

		Panchayat p2 = new Panchayat(); // --> Object 2

		System.out.println("------------------------------------------------");

		Panchayat p3 = new Panchayat(); // --> Object 3

		System.out.println("------------------------------------------------");

		System.out.println("Main End");
	}

}
