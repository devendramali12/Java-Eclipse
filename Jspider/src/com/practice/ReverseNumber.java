package com.practice;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Number :- ");
		int num = sc.nextInt();

		int rev = 0;
		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;
		}
		System.out.println("The Revser Of a Given number is " + rev);
		sc.close();
	}
}
