package box4;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number:- ");
		int num = sc.nextInt();

		int sum = 0;
		while (num != 0) {
			int last = num % 10;
			sum += last;
			num = num / 10;
		}

		System.out.println("The Sum Of Digits In a Number is :- " + sum);
		sc.close();
	}

}
