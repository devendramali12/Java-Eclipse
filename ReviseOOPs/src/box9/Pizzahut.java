package box9;

class pizza {
	void piza() {
		System.out.println("Small Pizza");
	}

	void piza(int a) {
		System.out.println("Big Pizza");
	}

	void piza(char ch) {
		System.out.println("Large Pizza");
	}

	void piza(double d) {
		System.out.println("XXL Pizza");
	}
}

public class Pizzahut {
	public static void main(String[] args) {
		pizza p1 = new pizza();
		p1.piza(2);
	}

}
