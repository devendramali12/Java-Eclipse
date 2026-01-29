package part1;

class Cap {
	private String color;
	private int price;

	public Cap() {
		System.out.println("Default Constructor");
	}

	public Cap(String color, int price) {
		this.color = color;
		this.price = price;

	}

	void info() {
		System.out.println("Cap Color is " + color + " Price is " + price);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

public class Encap {
	public static void main(String[] args) {
		Cap c1 = new Cap();
		c1.info();

		System.out.println("-------------------------");

		Cap c2 = new Cap("Pink", 250);
		System.out.println(c2.getColor());
		System.out.println(c2.getPrice());
		c2.info();

		System.out.println("-------------------------");
		c2.setColor("Black");
		c2.setPrice(125);
		c2.info();
	}

}
