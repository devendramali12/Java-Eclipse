package objectclass;

// Before Overriding toString

class Tesla {
	String color;
	int price;

	public Tesla(String color, int price) {
		this.color = color;
		this.price = price;
	}
}

public class Test {
	public static void main(String[] args) {
		Tesla t1 = new Tesla("Black", 110);
		System.out.println(t1);
		System.out.println(t1.toString());

		System.out.println("------------------------------------");

		Tesla t2 = new Tesla("Red", 100);
		System.out.println(t2);
		System.out.println(t2.toString());
	}

}
