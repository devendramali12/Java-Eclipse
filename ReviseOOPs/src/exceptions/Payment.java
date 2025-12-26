package exceptions;

import java.util.Scanner;

class InvalidAmountException extends Exception {
	public InvalidAmountException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
}

public class Payment {
	Scanner sc = new Scanner(System.in);

	void pay(int amount) throws InvalidAmountException {

//		System.out.println("Please Enter a Amount To Deposit");

		if (amount <= 0) {
			throw new InvalidAmountException("Invalid Amount ");
		}
		System.out.println("Payment SuccessFul");
	}

	public static void main(String[] args) {
//		pay(500);
		Payment p1 = new Payment();
//		p1.pay(500);
		try {
			p1.pay(-500);
		} catch (InvalidAmountException a) {
			System.out.println(a.getMessage());
		}
	}

}
