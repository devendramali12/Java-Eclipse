package exceptions;

import java.util.Scanner;

class InvalidMarkException extends Exception {
	public InvalidMarkException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
}

public class MarkApp {

	static void checkMarks(int marks) throws InvalidMarkException {
		if (marks < 0 || marks > 100) {
			throw new InvalidMarkException("Marks Must Be Between 0 and 100");
		}
		System.out.println("Valid Marks");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Marks :- ");
			int m = sc.nextInt();
			checkMarks(m);
		} catch (InvalidMarkException m) {
			System.out.println(m.getMessage());
		} finally {
			sc.close();
		}
	}

}
