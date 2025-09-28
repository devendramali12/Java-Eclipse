package constructor;

class realme {
	String Brand;
	int price;

	realme(String a, int b) { // Parametrized Constructor
		Brand = a;
		price = b;
	}

	void info() {
		System.out.println("The SmartPhone Name is " + Brand + " Its Price is " + price);
	}
}

public class SmartPhone {
	public static void main(String[] args) {
		realme r1 = new realme("Realme 3 ", 15000);
		r1.info();

	}

}
