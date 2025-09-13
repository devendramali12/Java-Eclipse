package oops;

class saap {
	static String s = "Saap Hai Sab"; // Global Static Variable
	static int n = 9307; // Global Static Variable

	static void saapokesaap() {
		System.out.println("Heyy Baby");
	}
}

public class Snake {
	public static void main(String[] args) {

		System.out.println(saap.s);
		System.out.println(saap.n);

		saap.saapokesaap();

	}

}
