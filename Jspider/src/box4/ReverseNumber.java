package box4;

import java.util.*;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number:- ");
		int num = sc.nextInt();
		int rev = 0;
		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;

		}
		System.out.println("The Reverse Of Given Number is :- " + rev);
		sc.close();

	}

}
