package level1;

import java.util.Scanner;

// ---> Check if a given year is a leap year

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Year");
		int year = sc.nextInt();

		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println(year + " is a Leap Year");
		} else {
			System.out.println(year + " is Not a Leap Year");
		}
		sc.close();

	}

}
