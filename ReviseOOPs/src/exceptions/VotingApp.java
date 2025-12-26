package exceptions;

class InvalidAgeException extends Exception {
	InvalidAgeException(String msg) {
		super(msg);
	}
}

public class VotingApp {
	static void checkage(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Age Must Be Above 18 ");
		}
		System.out.println("Eligible to vote");
	}

	public static void main(String[] args) {
		try {
			checkage(16);

		} catch (InvalidAgeException a) {
			System.out.println(a.getMessage());
		}
	}

}
