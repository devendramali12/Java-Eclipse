package box1;

public class ReverseString {
	public static void main(String[] args) {
		String str = "mom";
		String pal = str;
		String rev = "";

		for (int i = 0; i < str.length(); i++) {
			rev = str.charAt(i) + rev;

		}
		System.out.println(rev);
		if (pal == rev) {
			System.out.println("The Given String is a Palindrome String");
		} else {
			System.out.println("The Given String is not a palindrome String");
		}
	}

}
