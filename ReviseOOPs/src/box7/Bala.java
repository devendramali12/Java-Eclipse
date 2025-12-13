package box7;

public class Bala {
	static { // --> Static Block 1
		System.out.println("Sachi Joined QSpiders...");

	}
	static { // --> Static Block 2
		System.out.println("Vedant is very happy...");

	}

	public static void main(String[] args) {
		System.out.println("1 --> Main Start");
		System.out.println("2 --> Main End");
	}

	static { // --> Static Block 3
		System.out.println("Sanchi Got Placed");
	}
	static { // --> Static Block 3
		System.out.println("Vedant Become Devdas");

	}

}
