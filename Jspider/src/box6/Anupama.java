package box6;
// ---> Hierarchical Inheritance

class pitaji {
	void house() {
		System.out.println("Big Bunglow");
	}

	void gold() {
		System.out.println("10 Kg Gold");
	}
}

class yash extends pitaji {
	void study() {
		System.out.println("Studying ");
	}
}

class kirthi extends pitaji {
	void dance() {
		System.out.println("Dancer");
	}
}

public class Anupama {
	public static void main(String[] args) {

		yash y1 = new yash();
		y1.gold();
		y1.house();
		y1.study();

		System.out.println("------------------------------------------");

		kirthi k1 = new kirthi();
		k1.dance();
		k1.gold();
		k1.house();

	}
}
