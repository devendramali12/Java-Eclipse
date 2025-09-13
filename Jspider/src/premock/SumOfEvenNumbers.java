package premock;

import java.util.Scanner;

public class SumOfEvenNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		System.out.println("Please Enter a Number To Get The Sum Of Even Number");
		int a = sc.nextInt();

		for (int i = 0; i <= a; i++) {
			if (i % 2 == 1) {
				sum = sum + i;
			}
		}
		System.out.println("Sum Of Odd Number is " + sum);
		sc.close();

	}

}
