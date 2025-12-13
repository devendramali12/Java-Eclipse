package box9;

public class Deepwali {
	static void food() {
		System.out.println("Chakali");
	}

	static void food(int a) {
		System.out.println("Chivda");
	}

	static void food(char ch) {
		System.out.println("Ladu");
	}

	static void food(double d) {
		System.out.println("Shev");
	}

	public static void main(String[] args) {
		System.out.println("Deep Start");

		Deepwali.food();
		Deepwali.food(5);
		Deepwali.food('A');
		Deepwali.food(5.3);

		System.out.println("Deep End");
	}

}
