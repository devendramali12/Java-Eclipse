package exceptionhandling;

class InvalidageException extends Exception {
	InvalidageException(String msg) {
		super(msg);
	}
}

public class Test6 {

	static void checkage(int age) throws InvalidageException {
		if (age < 18) {
			throw new InvalidageException("Invalid age");
		} else {
			System.out.println("Valid Age");
		}
	}

	public static void main(String[] args) {
		try {
			checkage(12);

		} catch (InvalidageException e) {
			System.out.println(e.getMessage());
		}
	}

}
