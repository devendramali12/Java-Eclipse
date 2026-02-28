package exceptionn;

public class FinallyExample {
	public static void main(String[] args) {
		try {
			int x = 5 / 0;
		} catch (Exception e) {
			System.out.println("Exception Handles");
		} finally {
			System.out.println("Finally Block Always Runs");
		}
	}

}
