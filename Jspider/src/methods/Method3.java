package methods;
//With Return Type Without Parameter

import java.util.Scanner;

public class Method3 {
	public static double multiply() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter 1st Number:-");
		double num1 = sc.nextDouble();

		System.out.println("Please Enter 2nd Number:- ");
		double num2 = sc.nextDouble();

		double mul = num1 * num2;

		System.out.println("The Multiplication Of Given Two Number is " + mul);
		sc.close();
		return mul;

	}

	public static void main(String[] args) {
		multiply();

	}
}
