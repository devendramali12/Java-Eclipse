package logical1;

public class Fibo {
	public static void main(String[] args) {
		int one = 0;
		int two = 1;
		int num = 10;

		System.out.print(one + " " + two + " ");

		for (int i = 3; i <= num; i++) {
			int third = one + two;
			System.out.print(third + " ");
			one = two;
			two = third;
		}
	}

}
