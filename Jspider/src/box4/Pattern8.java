package box4;

public class Pattern8 {
	public static void main(String[] args) {
		int rn = 13, cn = 13;
		for (int r = 1; r <= rn; r++) {
			for (int c = 1; c <= cn; c++) {
				if (r == 1 || r == rn || c == 1 || c == cn || r == (rn / 2 + 1) || c == (cn / 2 + 1)) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

}
