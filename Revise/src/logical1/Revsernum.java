package logical1;

import java.util.Scanner;

public class Revsernum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Number");
		int num = sc.nextInt();
		int rev = 0;

		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num /= 10;
		}
		System.out.println("Revered Number is " + rev);
		sc.close();
	}

}
