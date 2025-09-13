package oops;

class Mishra {
	static String s = "Singer"; // ---> Static Global Variable
	String str = "love"; // ---> Non-Static Global Variable

	static void aarambh() { // ---> Static Method
		System.out.println("Aarambh Hai");
	}

	void event() { // ---> Non Static Method
		System.out.println("Sion");
	}
}

public class Piyush {
	public static void main(String[] args) {
		System.out.println(Mishra.s); // Accessing Static Members
		System.out.println(new Mishra().str); // Accessing Non-Static Members

		Mishra.aarambh();
		new Mishra().event();
	}

}
