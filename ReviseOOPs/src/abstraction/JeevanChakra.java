package abstraction;

abstract class swarg { // --> Abstract Class
	abstract void rambha();

	abstract void urvashi();

	abstract void menka();

	void narad() {
		System.out.println("Narayan Narayan");
	}
}

abstract class indra extends swarg {
	@Override
	void rambha() {
		System.out.println("Lavni");
	}

	@Override
	void menka() {
		System.out.println("BharatNatyam");
	}
}

class satyam extends indra {
	@Override
	void urvashi() {
		System.out.println("Kathak Satyam Ke Saath..");

	}
}

public class JeevanChakra {
	public static void main(String[] args) {
		swarg s1 = new satyam();
		s1.menka();
		s1.urvashi();
		s1.rambha();
		s1.narad();
	}

}
