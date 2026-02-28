package interfaces;

interface Printer {
	void print();

	default void scan() {
		System.out.println("Scanning Document");
	}
}

class hp implements Printer {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Printing From HP Printer");
	}

}

public class Test4 {
	public static void main(String[] args) {

		Printer p = new hp();
		p.print();
		p.scan();

	}

}
