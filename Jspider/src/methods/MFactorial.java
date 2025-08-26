package methods;

public class MFactorial {
	public static int fact(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * fact(n - 1);
	}

	public static void main(String[] args) {
		int num = 5;

		System.out.println("Factorial Of " + num + " = " + fact(num));
	}

}
