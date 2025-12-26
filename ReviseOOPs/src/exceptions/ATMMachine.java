package exceptions;

import java.util.Scanner;

class OutOfBalanceException extends Exception {
	public OutOfBalanceException(String msg) {
		super(msg);
	}
}

public class ATMMachine {

	public static void withdraw() throws OutOfBalanceException {
		int bal = 10000;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Amount To withdraw");

		int wamt = sc.nextInt();

		if (wamt > bal) {
			throw new OutOfBalanceException("Balance Kam Hai Bhai");

		}
		bal -= wamt;
		System.out.println("Withdrawal SucessFull " + " Remaining Balance is " + wamt);
		sc.close();

	}

	public static void main(String[] args) {
		try {
			withdraw();
		} catch (OutOfBalanceException a) {
			System.out.println(a.getMessage());
		} finally {
			System.out.println("Thank You For Visting ");
		}
	}

}
