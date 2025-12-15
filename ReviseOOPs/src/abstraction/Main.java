package abstraction;

abstract class booking {
	abstract void book();
}

class hotelbooking extends booking {
	void book() {
		System.out.println("Hotel Booking Confirmed");
	}
}

class tourbooking extends booking {
	void book() {
		System.out.println("Tour Package Booked");
	}
}

public class Main {
	public static void main(String[] args) {
		booking b = new hotelbooking();
		b.book();
	}

}
