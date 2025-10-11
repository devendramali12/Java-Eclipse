package level1;

import java.util.Scanner;

// ---> Check if a number is even or odd. 

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number");
		int num = sc.nextInt();

		if (num == 0) {
			System.out.println("The number is Zero");
		} else if (num % 2 == 0) {
			System.out.println(num + " is an Even number");
		} else {
			System.out.println(num + " is an Odd number");
		}

		sc.close();
	}

}
