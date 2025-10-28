package level3;

import java.util.Scanner;

// --> 1. Take a 3-digit number and check if all digits are distinct.
public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a 3-Digit number");
		int num = sc.nextInt();

		if (num < 100 || num > 999) {
			System.out.println("Please Enter a valid 3-digit number");
			return;
		}
		int a = num / 100;
		int b = (num / 10) % 10;
		int c = num % 10;

		if (a != b && b != c && a != c) {
			System.out.println("All Digits are distint");
		} else {
			System.out.println("Digits are not distinct");
		}

	}

}
