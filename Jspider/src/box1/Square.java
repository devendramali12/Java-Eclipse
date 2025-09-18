package box1;

public class Square {
	public static void main(String[] args) {
		int rn = 10;
		int cn = 10;

		for (int r = 1; r <= rn; r++) {
			for (int c = 1; c <= cn; c++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
