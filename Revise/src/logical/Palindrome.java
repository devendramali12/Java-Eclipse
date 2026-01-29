package logical;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Number :- ");
		int num = sc.nextInt();

		int dup = num;
		int rev = 0;

		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;

		}
		if (dup == rev) {
			System.out.println(dup + " Is a Palindrome Number...");

		} else {
			System.out.println(dup + " Isn't a Palindrome Number..");
		}
		sc.close();

	}

}
