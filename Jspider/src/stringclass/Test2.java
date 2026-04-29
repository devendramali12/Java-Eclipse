package stringclass;

class ninja {
	String color;

	public ninja(String color) {
		this.color = color;
	}
}

public class Test2 {
	public static void main(String[] args) {
		ninja n1 = new ninja("Pink");
		ninja n2 = new ninja("Pink");
		System.out.println(n1.equals(n2));

		System.out.println("----------------");

		String s1 = new String("Niket");
		String s2 = new String("Niket");
		System.out.println(s1.equals(s2));
		/*
		 * Equals() should have compared the address or references of two objects but in
		 * string class it is overridden to compare the data or content.
		 */
	}

}
