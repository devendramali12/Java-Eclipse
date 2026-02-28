package exceptionn;

public class TryCatchExample {
	public static void main(String[] args) {
		try {
			int a = 10;
			int b = 0;
			int res = a / b;
			System.out.println(res);
		} catch (ArithmeticException e) {

			System.out.println("CanNot Divide by zero");
		}
		System.out.println("Program Continues");
	}
}
