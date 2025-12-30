package generalizationSpecialization;

// --> Parent Class (Generalization)
class Account {
	double balance = 5000;

	// --> Common Method
	void deposit(double amount) {
		balance += amount;
		System.out.println("Balance After Deposit:- " + balance);
	}

}

// --> Child Class (Specialization)
class savingaccount extends Account {

	// --> Savings-specific behavior
	void addinterest() {
		System.out.println("Interest addes to savings account");
	}
}

// --> Child Class (Specialization)
class currentaccount extends Account {
	void overdraft() {
		System.out.println("Overdraft facility available");
	}
}

public class BankTest {
	public static void main(String[] args) {
		savingaccount s1 = new savingaccount();
		s1.deposit(2000);
		s1.addinterest();

		System.out.println("---------------");
		currentaccount c1 = new currentaccount();
		c1.deposit(1000);
		c1.overdraft();

	}

}
