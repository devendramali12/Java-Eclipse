package box1;

import java.util.Scanner;

public class ReverseNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number :- ");
		int num = sc.nextInt();
		int pan = num;
		int rev = 0;

		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num /= 10;

		}
		System.out.println("The Reverse Of a Given Number is :- " + rev);

		if (pan == rev) {
			System.out.println("The Number is palindrome");
		} else {
			System.out.println("The Number is not a palindrome");
		}
		sc.close();

	}

}
