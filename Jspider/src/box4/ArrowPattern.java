package box4;

public class ArrowPattern {
	public static void main(String[] args) {
		int rn = 10, cn = 10;
		for (int r = 1; r <= rn; r++) {
			for (int c = 1; c <= cn; c++) {
				if (r == 1 || c == cn || r + c == (rn + 1)) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

}
