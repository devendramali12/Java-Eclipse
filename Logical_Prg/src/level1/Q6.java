package level1;

import java.util.Scanner;

// ---> Take two numbers and print the larger one.
public class Q6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter 1st Number");
		int a = sc.nextInt();

		System.out.println("Please Enter 2nd Number");
		int b = sc.nextInt();

		if (a > b) {
			System.out.println(a + " is the largest number");
		} else if (b > a) {
			System.out.println(b + " is the largest number");
		} else {
			System.out.println("Both numbers are equal");
		}
		sc.close();
	}

}
