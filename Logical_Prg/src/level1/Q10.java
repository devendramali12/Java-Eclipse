package level1;

public class Q10 {

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

		int a = 1;
		int b = 50;

		for (int i = a; i <= b; i++) {
			if (isprime(i)) {
				System.out.println(i + " Is a Prime Number");
			}
		}
	}

}
