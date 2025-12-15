package exceptionn;

public class NullDemo {
	public static void main(String[] args) {

		String s = null;
		try {
			System.out.println(s.length());
		} catch (NullPointerException n1) {
			System.out.println("String Is Null...");
		}
	}

}
