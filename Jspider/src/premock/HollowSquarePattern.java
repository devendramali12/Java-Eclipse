package premock;

public class HollowSquarePattern {
	public static void main(String[] args) {
		int rn = 10;
		int cn = 10;

		for (int r = 1; r <= rn; r++) {
			for (int c = 1; c <= cn; c++) {
				if (r == 1 || r == rn || c == 1 || c == cn) {
					System.out.print("* ");

				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
