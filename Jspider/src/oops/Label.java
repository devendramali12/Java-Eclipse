package oops;

class Lallabel {
	static String str = "Red Hu";
	static int price = 2500;

	static void info() {
		System.out.println(str + " Aur Mehnga Bhi Hu " + price);

	}

}

class BlueLabel {
	String str = "Neela Hu";
	int price = 3500;

	void nil() {
		System.out.println("Aasman Ki Tarah " + str + " Aur Mehnga Bhi " + price);
	}

}

public class Label {
	public static void main(String[] args) {
		System.out.println(Lallabel.str);
		System.out.println(Lallabel.price);
		Lallabel.info();

		System.out.println();
		System.out.println();

		System.out.println(new BlueLabel().price);
		System.out.println(new BlueLabel().str);
		new BlueLabel().nil();

	}

}
