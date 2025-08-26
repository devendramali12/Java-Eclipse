package box4;

public class ReveseArrow {
	public static void main(String[] args) {
		int rn = 10, cn = 10;
		for (int r = 1; r <= rn; r++) {
			for (int c = 1; c <= cn; c++) {
				if (r == 1 || c == r || c == 1) {
					System.out.print("❤️ ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

}
