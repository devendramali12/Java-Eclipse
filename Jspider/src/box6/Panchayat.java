package box6;
/*
Non-static blocks run every time an object is created, before the constructor.

If you had a static block, it would run only once, when the class loads.
 */

public class Panchayat {

	Panchayat() {
		System.out.println("C.. Inside Panchyat Constructor");
	}

	{
		// Non-Static Block 1
		System.out.println("A..Aur Karo Meeting Meeting");

	}
	{
		// Non- Static Block 2
		System.out.println("B.. Gajab Bejati hai ...");
	}

	public static void main(String[] args) {

		System.out.println("D .. Main Start");

		Panchayat p1 = new Panchayat(); // --> Object 1
		System.out.println("------------------------------------");

		Panchayat p2 = new Panchayat(); // --> Object 2
		System.out.println("-------------------------------------");

		Panchayat p3 = new Panchayat(); // --> Object 3
		System.out.println("--------------------------------------");

		System.out.println("Main End");

	}

}
