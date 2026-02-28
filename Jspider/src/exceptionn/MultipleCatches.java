package exceptionn;

public class MultipleCatches {
	public static void main(String[] args) {

		try {
			int arr[] = new int[5];
			arr[10] = 50;

		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Exception");
		} catch (Exception e) {
			System.out.println("Gernal Exception");
		}
	}
}
