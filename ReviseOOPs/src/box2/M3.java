package box2;

import java.util.Scanner;

public class M3 {

	public static int sum() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a First Number");
		int num1 = sc.nextInt();

		System.out.println("Please Enter a Second Number");
		int num2 = sc.nextInt();

		int sum = num1 + num2;
		System.out.println("Sum of given Number is " + sum);

		sc.close();

		return sum;

	}

	public static void main(String[] args) {

		sum();
	}
}
