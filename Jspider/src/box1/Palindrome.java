package box1;

public class Palindrome {
	public static void main(String[] args) {
		String str = "rutika";
		String temp = str;
		String rev = "";

		for (int i = 0; i < str.length(); i++) {
			rev = str.charAt(i) + rev;

		}
		System.out.println("The Reversed String Is " + rev);
		if (temp.equals(rev)) {
			System.out.println("The Given String Is String Palindorme");
		} else {
			System.out.println("The Given String Is Not a String Palindorme");
		}
	}

}
