package box4;

import java.util.Scanner;

public class FactorialOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number To Get Factorial :-  ");
		long n = sc.nextLong();
		long fact = 1;

		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println("The Factorial Of " + n + " Is " + fact);
		sc.close();

	}

}
