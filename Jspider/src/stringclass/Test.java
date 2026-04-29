package stringclass;

class kiwi {
	String c;

	public kiwi(String c) {
		this.c = c;
	}
}

public class Test {
	public static void main(String[] args) {
		kiwi k1 = new kiwi("Green");
		kiwi k2 = new kiwi("Red");

		System.out.println(k1);
		System.out.println(k2.toString());

		System.out.println("-----------------------------------");

		String s1 = new String("Roshan");
		String s2 = new String("Sneha");

		System.out.println(s1);
		System.out.println(s2.toString());
		/*
		 * roString() Should have returned String representation of the object (address)
		 * but in String Class it is Overridden to return the data
		 */
	}
}
