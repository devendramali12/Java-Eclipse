package polymorph;

// Polymorphism Using Interface (Most Important)

interface payment {
	void pay();
}

class creditcard implements payment {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Payment using Credit card");
	}

}

class upi implements payment {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Payment using UPI");
	}

}

public class PaymentTest {
	public static void main(String[] args) {
		payment p1 = new creditcard();
		p1.pay();

		payment p2 = new upi();
		p2.pay();
	}

}
