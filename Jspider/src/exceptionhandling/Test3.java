package exceptionhandling;

public class Test3 {
	public static void main(String[] args) {
		try {
			int x = 5 / 0;
		} catch (Exception e) {
			System.out.println("Exception occurred");
		} finally {
			System.out.println("Finally Block Always executes");
		}
	}
}
