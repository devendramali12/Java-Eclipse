package interfaces;

interface printer {
	default void print() {
		System.out.println("Printing Document");
	}
}

class laserprinter implements printer {
	@Override
	public void print() {
		System.out.println("Printing Using Laser Printer");
	}
}

public class I4 {
	public static void main(String[] args) {
		printer p1 = new laserprinter();
		p1.print();
	}

}
