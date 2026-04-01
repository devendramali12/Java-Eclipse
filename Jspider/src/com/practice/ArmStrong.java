package com.practice;

import java.util.Scanner;

public class ArmStrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Number :-");
		int num = sc.nextInt();
		int original = num;
		int sum = 0;

		while (num != 0) {
			int last = num % 10;
			sum = (sum) + last * last * last;
			num = num / 10;
		}

		if (original == sum) {
			System.out.println("ArmStrong Number");
		} else {
			System.out.println("Not an ArmStrong Number");
		}

	}

}
