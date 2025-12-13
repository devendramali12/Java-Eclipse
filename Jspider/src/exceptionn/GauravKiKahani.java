package exceptionn;

import java.util.Scanner;

public class GauravKiKahani {
	public static void main(String[] args) {
		System.out.println("Gaurav Start");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1St Number");
		int n1 = sc.nextInt();

		System.out.println("Enter 2nd Number");
		int n2 = sc.nextInt();

		try {
			System.out.println(n1 / n2);

		} catch (ArithmeticException a1) {
			System.out.println("Zero Se Divide Mat Kar");

		}
		sc.close();
	}
}
