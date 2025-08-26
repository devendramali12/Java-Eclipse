package methods;

public class FibonacciSeries {
	public static long fib(int num) {
		long first = 0;
		long second = 1;
		System.out.print(first + " " + second + " ");

		for (int i = 3; i <= num; i++) {
			long third = first + second;
			System.out.print(third + " ");
			first = second;
			second = third;
		}
		System.out.println();
		return first;

	}

	public static void main(String[] args) {
		fib(20);
		fib(50);

	}

}
