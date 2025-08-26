
package box4;

import java.util.Scanner;

public class PalindromeNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number:- ");
		int num = sc.nextInt();
		int temp = num;
		int rev = 0;

		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;

		}
		if (rev == temp) {
			System.out.println("The Given Number is a Palindrome Number");
		} else {
			System.out.println("The Given Number isn't a Palindrome Number");
		}
		sc.close();

	}

}
