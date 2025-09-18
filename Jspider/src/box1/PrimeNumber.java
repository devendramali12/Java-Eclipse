package box1;

public class PrimeNumber {
	public static boolean isprime(int num) {
		if (num < 1) {
			return false;
		}
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 5;

		if (isprime(n)) {
			System.out.println(n + " Is a Prime");
		} else {
			System.out.println(n + " Is Not a Prime");
		}

	}

}
