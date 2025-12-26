package programs;

public class PrimeNum {
	public static boolean isprime(int num) {
		if (num < 1) {
			return false;
		}
		for (int i = 2; i < num; i++) {
			if (num % 2 == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		for (int i = 0; i <= 100; i++) {
			if (isprime(i)) {
				System.out.println(i + " Is a Prime Number");
			}
		}

	}
}
