package level1;

import java.util.Scanner;

// --> 1. Take a number and print whether it’s positive, negative, or zero.
public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a Number To" + " Check Whether Its positive , Negative or Zero");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.println(num + " Is Positive Number");
		} else if (num < 0) {
			System.out.println(num + " Is a Negative Number");
		} else {
			System.out.println(num + " IS a Zero");
		}
		sc.close();

	}
}
