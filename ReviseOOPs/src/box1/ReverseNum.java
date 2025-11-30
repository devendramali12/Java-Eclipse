package box1;

import java.util.Scanner;

public class ReverseNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number");

		int num = sc.nextInt();

		int rev = 0;

		int temp = num;

		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;

		}
		System.out.println("Reversed Number is " + rev);

		if (temp == rev) {
			System.out.println("Number Is Palindrome");
		}
		sc.close();

	}

}
