package logical1;

public class Primenumber {

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

		int num = 11;

		if (isprime(num)) {
			System.out.println(num + " Is a Prime Number");
		} else {
			System.out.println(num + " Is Not a Prime Number");
		}

	}

}
