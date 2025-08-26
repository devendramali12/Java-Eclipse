package box4;

public class PrimeNumber {
	public static boolean isprime(int num) {
		if (num <= 1) {
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
		// TODO Auto-generated method stub
		int n = 5;
		if (isprime(n)) {
			System.out.println(n + " Is a Prime Number ");
		} else {
			System.out.println(n + " Isn't a Prime Number");
		}

	}

}
