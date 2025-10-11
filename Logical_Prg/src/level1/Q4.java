package level1;

import java.util.Scanner;

// --> Check if a number is divisible by both 3 and 5.
public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number");
		int num = sc.nextInt();

		if (num % 3 == 0 && num % 5 == 0) {
			System.out.println(num + " Is Divisible by both 3 & 5");

		} else {
			System.out.println(num + " Is Not divisible by 3 & 5");
		}
		sc.close();

	}

}
