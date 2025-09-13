package premock;

public class PrimeNumber {
	public static boolean isprime(int num) {
		if (num < 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 554129;

		if (isprime(n)) {
			System.out.println(n + " Is a Prime Number");
		} else {
			System.out.println(n + " Is Not a Prime Number");
		}

	}
}
