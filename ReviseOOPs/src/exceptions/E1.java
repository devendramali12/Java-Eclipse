package exceptions;

import java.util.Scanner;

public class E1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter 1St Number");
		int n1 = sc.nextInt();

		System.out.println("Please Enter 2nd Number");
		int n2 = sc.nextInt();

		try {
			System.out.println("Division Of Two Number is " + n1 / n2);
		} catch (ArithmeticException a1) {
			System.out.println("Zero Se Kon Divide Karta Hai Bhai");
		}

	}
}
