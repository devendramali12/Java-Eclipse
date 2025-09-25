package constructor;

class brand {
	String s;
	int price;

	brand(String a, int b) {
		s = a;
		price = b;
	}

	void info() {
		System.out.println("The SmartPhone Brand is :- " + s + " Price is:- $ " + price);
	}
}

public class Brandriver {
	public static void main(String[] args) {
		brand b1 = new brand("Apple", 60000);
//		System.out.println(b1.price);
//		System.out.println(b1.s);
		b1.info();

		brand b2 = new brand("Samsung", 25000);
		b2.info();

		brand b3 = new brand("Motorola", 35000);
		b3.info();
	}

}
