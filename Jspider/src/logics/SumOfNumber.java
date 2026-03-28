package logics;

import java.util.Scanner;

public class SumOfNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Number :- ");
		int num = sc.nextInt();

		int sum = 0;

		while (num != 0) {
			int last = num % 10;
			sum += last;
			num /= 10;
		}
		System.out.println("The Sum Of Digits is " + sum);
		sc.close();
	}

}
