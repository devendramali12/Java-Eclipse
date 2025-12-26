package exceptions;

class LowBalanceException extends RuntimeException {

	public LowBalanceException(String msg) {
		super(msg);
	}

}

public class BankApp {
	static void withdraw(int balance, int amt) {
		if (amt > balance) {
			throw new LowBalanceException("Insufficient Balance");
		}
		System.out.println("Withdrawal Successful");
	}

	public static void main(String[] args) {
		withdraw(5000, 7000);
	}
}
