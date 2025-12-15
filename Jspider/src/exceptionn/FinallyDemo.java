package exceptionn;

public class FinallyDemo {
	public static void main(String[] args) {
		try {
			int a = 10 / 0;
			System.out.println(a);
		} catch (Exception e) {
			System.out.println("Error Occured");
		} finally {
			System.out.println("Finally Block always Executes");
		}
	}

}
