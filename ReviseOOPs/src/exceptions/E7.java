package exceptions;

// --> Finally Without Catch

public class E7 {
	public static void main(String[] args) {
		try {
			System.out.println("Inside Try");
		} finally {
			System.out.println("Finally Executed");
		}
	}

}
