package box4;

public class PalindromeString {
	public static void main(String[] args) {
		String str = "mom";
		String rev = "";
		String temp = str;

		for (int i = 0; i < str.length(); i++) {
			rev = str.charAt(i) + rev;
		}

		if (temp .equals(rev)) {
			System.out.println("The Given String Is a Palindrome");
		} else {
			System.out.println("The Given String Isn't a Palindrome");
		}
	}

}
