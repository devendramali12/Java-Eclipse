package exceptionhandling;

public class Test7 {
	public static void main(String[] args) {
		try {
			try {
				int a = 10 / 0;
			} catch (ArithmeticException e) {
				System.out.println("Inner Catch");
			}
			int arr[] = new int[2];
			arr[5] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Oyer Catch");
		}
	}

}
