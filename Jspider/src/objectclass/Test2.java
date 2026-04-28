package objectclass;

// --> After Overriding toString()
class tesla {
	String color;
	int price;

	public tesla(String color, int price) {
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car Color is " + color + " Price is " + price;
	}
}

public class Test2 {
	public static void main(String[] args) {
		tesla t1 = new tesla("Black", 100);
		System.out.println(t1);
		System.out.println(t1.toString());

		System.out.println("--------------------------");

		tesla t2 = new tesla("pink", 500);
		System.out.println(t2);
		System.out.println(t2.toString());
	}

}
