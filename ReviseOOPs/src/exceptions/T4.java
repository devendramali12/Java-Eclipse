package exceptions;

public class T4 {

	public static void buliding() throws ArrayIndexOutOfBoundsException {
		int[] arr = { 20, 12, 45, 65, 23, 65 };
		System.out.println(arr[12]);
	}

	public static void main(String[] args) {

		try {
			buliding();
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Terrace Pe Jaa RAha hai tu");
		}

	}

}
