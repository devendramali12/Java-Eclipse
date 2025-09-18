package box1;

import java.util.Scanner;

public class Facto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Number To Get Factorial");
		int n = sc.nextInt();

		int fact = 1;

		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		System.out.println("Factorial Of a Given Number Is :-  " + fact);
		sc.close();

	}

}
