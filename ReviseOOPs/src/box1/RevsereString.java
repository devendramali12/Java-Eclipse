package box1;

public class RevsereString {
	public static void main(String[] args) {
		String str = "Devendra";
		String rev = "";

		for (int i = 0; i < str.length(); i++) {
			rev = str.charAt(i) + rev;

		}
		System.out.println("Reversed String is " + rev);
	}

}
