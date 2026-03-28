package logics;

public class FactoByRec {
	public static int fact(int num) {
		if (num == 0) {
			return 1;
		}
		return num * fact(num - 1);
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println("The factorial of " + n + " is " + fact(n));

	}

}
