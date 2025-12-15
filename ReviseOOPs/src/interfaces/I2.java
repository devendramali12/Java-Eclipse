package interfaces;

// --> Multiple Inheritance using Interface
interface a {
	void showa();
}

interface b {
	void showb();
}

class c implements a, b {
	public void showa() {
		System.out.println("Method Of Interface A");
	}

	public void showb() {
		System.out.println("Method Of Interface B");
	}
}

public class I2 {
	public static void main(String[] args) {
		a a1 = new c();
		a1.showa();
//		a1.showb();

		b a2 = new c();
		a2.showb();

	}

}
