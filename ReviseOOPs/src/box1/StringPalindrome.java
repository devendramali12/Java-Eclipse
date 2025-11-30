package box1;

public class StringPalindrome {
	public static void main(String[] args) {

		String str = "mom";
		String rev = "";
		String temp = str;

		for (int i = 0; i < str.length(); i++) {
			rev = str.charAt(i) + rev;

		}
		if (rev.equals(temp)) {
			System.out.println("String Is Palindrome");
		}
	}

}
