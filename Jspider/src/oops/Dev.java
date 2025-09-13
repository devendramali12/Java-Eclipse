package oops;

class Anju {
	static String s = "Baby"; // Static String Variable
	static int n = 1234; // Static Global Variable

	static void beta() {
		System.out.println("Hello Beta.. How are you");
	}

}

public class Dev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Anju.s);
		System.out.println(Anju.n);

		Anju.beta();

	}

}
