package box4;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = 0;
		int second = 1;
		System.out.println("Please Enter a Number To get Fibonacci Series");
		int temp = sc.nextInt();
		
		System.out.print(first + " " + second + " ");
		
		for(int i = 3; i<= temp; i++) {
			int third = first + second;
			System.out.print(third+" ");
			first = second ;
			second = third;
		}
		sc.close();

	}

}
