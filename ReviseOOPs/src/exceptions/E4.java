package exceptions;
// --> Nested Try–Catch

public class E4 {
	public static void main(String[] args) {
		try {
			try {
				int a = 10 / 0;
				System.out.println(a);
			} catch (ArithmeticException e) {
				System.out.println("Inner Try Block Exception");
			}
			int[] arr = new int[2];
			arr[5] = 10;
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Outer Try Block Exception");
		}
	}

}
