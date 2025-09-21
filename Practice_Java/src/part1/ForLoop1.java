package part1;

public class ForLoop1 {
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println();

		for (int i = -10; i <= 0; i++) {
			System.out.print(i + " ");
		}

	}

}
