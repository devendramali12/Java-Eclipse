package logical;

public class Fibonacci {
	public static void main(String[] args) {

		int one = 0;
		int two = 1;

		System.out.print(one + " " + two + " ");

		int num = 10;

		for (int i = 3; i <= num; i++) {
			int third = one + two;
			System.out.print(third + " ");
			one = two;
			two = third;
		}
	}

}
