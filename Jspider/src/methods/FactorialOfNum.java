package methods;

public class FactorialOfNum {
	public static long fact(int num) {
		long fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
		return fact;

	}

	public static void main(String[] args) {
		fact(5);
		fact(0);
		fact(1);
		fact(2);
		fact(3);
		fact(4);
		fact(5);

	}

}
