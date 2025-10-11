package level1;

import java.util.Scanner;

// ---> Check if a number is divisible by 5.
public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number");
		int num = sc.nextInt();

		if (num % 5 == 0) {
			System.out.println(num + " Is Divisible by 5");
		} else {
			System.out.println(num + " Is Not Divisible by 5");
		}
		sc.close();
	}

}
