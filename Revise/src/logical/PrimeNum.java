package logical;

public class PrimeNum {
	public static boolean isprime(int num) {
		if (num < 2) {
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
		int num = 3;

		if (isprime(num)) {
			System.out.println(num + " Is a Prime Number");
		} else {
			System.out.println(num + " Isn't a Prime Number");
		}

		for (int i = 1; i <= 100; i++) {
			if (isprime(i)) {
				System.out.println(i);
			}
		}

	}

}
