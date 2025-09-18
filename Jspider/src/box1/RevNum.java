package box1;

import java.util.Scanner;

public class RevNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		int num = sc.nextInt();
		int rev = 0;

		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num /= 10;

		}
		System.out.println("The Reversed Of a Num is " + rev);
		sc.close();
	}
}
