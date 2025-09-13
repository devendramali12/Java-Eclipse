package oops;

class Ajeet {
	static String s = "Ajju"; // static global Variable
	static int n = 143; // static global variable

	static void love() { // Static method
		System.out.println("Aashique...");

	}
}

public class Anjali {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Main Start");

		System.out.println(Ajeet.s);
		System.out.println(Ajeet.n);

		Ajeet.love();

		System.out.println("Main End ");

	}

}
