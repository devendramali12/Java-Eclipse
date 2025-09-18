package box1;

public class p3 {
	public static void main(String[] args) {
		int rn = 10;
		int cn = 10;
		for (int r = 1; r <= rn; r++) {
			for (int c = 1; c <= cn; c++) {
				if (r == 1 || r == rn || c == 1 || c == cn || r == c || r + c == rn + 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

}
