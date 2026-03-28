package logics;

import java.util.Scanner;

public class Counts {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Entter a Number");
		int num = sc.nextInt();
		int count = 0;

		while (num != 0) {
			num /= 10;
			count++;
		}
		System.out.println("The Digits in number " + count);
		sc.close();
	}

}
