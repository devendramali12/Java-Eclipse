package box4;

public class Pattern6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rn = 18, cn = 18;
		for (int r = 1; r <= rn; r++) {
			for (int c = 1; c <= cn; c++) {
				if (r == 1 || r == rn || c == cn || c == 1 || r == c || r + c == (rn + 1)) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();

		}
	}
}
