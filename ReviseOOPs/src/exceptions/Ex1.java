package exceptions;

import java.util.Scanner;

// --> Program 1: Bank Withdrawal System

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int balance = 5000;

		try {
			System.out.println("Enter Withdraw Amount :- ");
			int amt = sc.nextInt();

			if (amt > balance) {
				throw new ArithmeticException("Insufficient Balance");
			}
			balance -= amt;
			System.out.println("Withdraw Successful");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
			System.out.println("Transaction End");
		}

	}

}
