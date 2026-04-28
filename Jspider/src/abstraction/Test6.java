package abstraction;

abstract class payment {
	abstract void pay(double amount);
}

class UPI extends payment {
	void pay(double amount) {
		System.out.println("paid " + amount + " via UPI");
	}
}

class Card extends payment {
	void pay(double amount) {
		System.out.println("paid " + amount + " via Card");
	}
}

public class Test6 {
	public static void main(String[] args) {
		payment p;
		p = new UPI();
		p.pay(500);

		p = new Card();
		p.pay(100);
	}

}
