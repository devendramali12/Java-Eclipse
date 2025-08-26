package methods;

public class PalindromeCheck {
	public static int palindrome(int num) {
		int temp = num;
		int rev = 0;
		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;

		}
		if (temp == rev) {
			System.out.println(rev + " Is a Palindrome Number");
		} else {
			System.out.println(rev + " Isn't a Palindrome Number");
		}
		System.out.println();
		return temp;
	}

	public static void main(String[] args) {
		palindrome(121);
		palindrome(142);

	}

}
