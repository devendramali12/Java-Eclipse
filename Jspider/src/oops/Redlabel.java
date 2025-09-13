package oops;

public class Redlabel {

	int age = 18; // Global variable

	static String color = " Red"; // Static Global Variable
	int price = 150; // Non - Static Global Variable

	public static void drink() { // Static Method
		System.out.println("Drinking Whiskey");

	}

	public void dance() {
		System.out.println("Break Dance......");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Main Statrt");

		int num = 10; // Local Variable ;
//		drink();
//		dance();
		System.out.println(num);
		System.out.println("Main End");

	}

}
