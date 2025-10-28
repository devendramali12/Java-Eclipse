package level3;

public class Fib {
	public static void main(String[] args) {

		int a = 0;
		int b = 1;
		int temp = 50;

		System.out.print(a + " " + b);
//		System.out.print(b);

		for (int i = 3; i <= temp; i++) {
			int c = a + b;
			if (c > 50) {
				break;
			}
			System.out.print(" " + c);

			a = b;
			b = c;
		}

	}

}
