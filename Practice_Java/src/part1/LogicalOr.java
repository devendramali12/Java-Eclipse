package part1;

public class LogicalOr {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(a < 50 || b < 100);

		System.out.println((a = a + 1) > 5 || (b = b + 5) < 20);
		System.out.println(a);
		System.out.println(b);

		System.out.println("----------------------------------------------------------");

		int x = 50;
		int y = 60;
		System.out.println((x = x + 1) > x || (y = y + 5) > 60);
		System.out.println(x);
		System.out.println(y);

		// In Case Of Logical or if first operand is true then we will
		// not execute the 2nd operand
	}

}
