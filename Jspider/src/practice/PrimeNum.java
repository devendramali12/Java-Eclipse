package practice;

public class PrimeNum

{
	public static boolean isprime(int num) {
		if (num < 2) {
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
		int n = 45896325;
		if (isprime(n)) {
			System.out.println(n + " Is a Prime Number");
		} else {
			System.out.println(n + " Not a Prime Number");
		}

	}

}
