package logical;

import java.util.Scanner;

public class ReverseNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a Numbers :- ");
		int num = sc.nextInt();

		int rev = 0;
		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;

		}
		System.out.println("Revsered Number is :- " + rev);
		sc.close();
	}

}
