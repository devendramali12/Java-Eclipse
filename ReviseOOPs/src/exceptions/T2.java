package exceptions;

public class T2 {

	static void divide(int a, int b) throws ArithmeticException {
		int c = a / b;
		System.out.println(c);
	}

	public static void main(String[] args) {
		try {
			divide(10, 0);
		} catch (ArithmeticException a) {
			System.out.println("Can Not Divide By Zero");
		}
		System.out.println("Program Continue");

	}

}
