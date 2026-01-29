package part1;

class baap {
	void ghar() {
		System.out.println("Sea-facing Bunglow");
	}
}

class beta extends baap {
	@Override
	void ghar() {
		System.out.println("Loves Bed-Room");
	}

}

class son extends beta {
	@Override
	void ghar() {
		System.out.println("Loves Wahsroom");
	}

}

public class Inherit {
	public static void main(String[] args) {

		baap b = new baap();
		b.ghar();

		System.out.println("-------------------------------");
		beta b1 = new beta();
		b1.ghar();

		System.out.println("-------------------------------");
		son s1 = new son();
		s1.ghar();
	}

}
