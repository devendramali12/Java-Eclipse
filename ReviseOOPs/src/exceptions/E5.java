package exceptions;
// --> NullPointerException

public class E5 {
	public static void main(String[] args) {
		String s = null;

		try {
			System.out.println(s.length());
		} catch (NullPointerException n1) {
			System.out.println("Null Values Can't be Accesed");
		}
	}

}
