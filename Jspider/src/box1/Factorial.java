package box1;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number:- ");

		int num = sc.nextInt();
		int fact = 1;

		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		System.out.println("Factoral Of a Number is " + fact);
		sc.close();
	}

}
