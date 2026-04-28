package exceptionhandling;

public class Test4 {
	public static void main(String[] args) {
		int age = 16;
		if (age < 18) {
			throw new ArithmeticException("Not Eligible for Voting");
		} else {
			System.out.println("Eligible to vote");
		}
	}

}
