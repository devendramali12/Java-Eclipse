package polymorph;

// Real-World Example (Bank System)
class bank {
	void getinterestrate() {
		System.out.println("Generic bank interest");
	}
}

class sbi extends bank {
	void getinterestrate() {
		System.out.println("SBI interest rate :- 6%");
	}
}

class hdfc extends bank {
	void interestrate() {
		System.out.println("HDFC interest rate 7%");
	}
}

public class BankTest {
	public static void main(String[] args) {
		bank b1 = new sbi();
		b1.getinterestrate();
	}

}
