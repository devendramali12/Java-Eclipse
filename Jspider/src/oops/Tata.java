package oops;

class Nano {
	String color = "Red";
	int price = 100;

	void info() {
		System.out.println("Desh ka Pride");

	}
}

public class Tata {
	public static void main(String[] args) {
		Nano n1 = new Nano();
//		System.out.println(new Nano().color);
		System.out.println(n1.color);

		Nano n2 = new Nano();
		n2.color = "Black";
		System.out.println(n2.color);
		n2.info();

	}

}
