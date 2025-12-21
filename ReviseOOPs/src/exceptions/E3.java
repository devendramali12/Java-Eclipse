package exceptions;

// --> Try–Catch–Finally
public class E3 {
	public static void main(String[] args) {
		try {
			int x = 10 / 2;
			System.out.println(x);
		} catch (Exception e) {
			System.out.println("Error Occured");
		} finally {
			System.out.println("Finally Block Always Executes");
		}
	}

}
