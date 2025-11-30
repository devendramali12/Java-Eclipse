package box1;

public class Fibo {
	public static void main(String[] args) {
		int first = 0;
		int second = 1;

		System.out.print(first + " " + second + " ");

		for (int i = 3; i <= 10; i++) {
			int third = first + second;
			System.out.print(third + " ");
			first = second;
			second = third;
		}
	}
}
