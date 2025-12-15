package exceptionn;

public class MultipleCatch {
	public static void main(String[] args) {

		try {
			int[] arr = new int[3];
			arr[5] = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception");
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Array Index Exception");
		} catch (Exception e) {
			System.out.println("General Exception");
		}
	}

}
