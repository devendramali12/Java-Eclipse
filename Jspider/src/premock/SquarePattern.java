package premock;

public class SquarePattern {
	public static void main(String[] args) {

		int row = 10;
		int col = 10;

		for (int r = 0; r <= row; r++) {
			for (int c = 0; c <= col; c++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}
}
