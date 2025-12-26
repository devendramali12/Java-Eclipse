package programs;

public class Fibo {
	public static void main(String[] args) {
		int one = 0;
		int second = 1;

		System.out.print(one + " " + second + " ");

		for (int i = 3; i <= 10; i++) {
			int third = one + second;
			System.out.print(third + " ");
			one = second;
			second = third;
		}
	}

}
