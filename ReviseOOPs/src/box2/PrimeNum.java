package box2;

public class PrimeNum {

	public static boolean isprime(int num) {
		if (num <= 1) {
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

//		int num = 17;

		for (int i = 0; i <= 100; i++) {
			if (isprime(i)) {
				System.out.println(i + " Is a Prime Number");
			}

		}
	}

}
