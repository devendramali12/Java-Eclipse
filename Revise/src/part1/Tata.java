package part1;

class nano {
	String color;
	int price;

	void info() {
		System.out.println("Car Color is " + color + " Price is " + price);
	}
}

public class Tata {
	public static void main(String[] args) {
		nano n1 = new nano();

		System.out.println(n1.color);
		System.out.println(n1.price);

		n1.info();

		System.out.println("-------------------------");

		n1.color = "Pink";
		n1.price = 125;

		System.out.println(n1.color);
		System.out.println(n1.price);
		n1.info();
	}

}
