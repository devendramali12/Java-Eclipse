package exceptions;

public class E2 {
	public static void main(String[] args) {
		try {
			int[] a = { 1, 2, 3 };
			System.out.println(a[5]);
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Index Out Of Range");
		} catch (Exception e) {
			System.out.println("General Exception");
		}
	}

}
