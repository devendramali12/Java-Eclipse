package methods;

public class EvenOdd {
	public static boolean OddEven(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		int n = 10;
		if (OddEven(n)) {
			System.out.println(n + " Is Even Number");
		} else {
			System.out.println(n + " Is Odd Number");
		}

	}

}
