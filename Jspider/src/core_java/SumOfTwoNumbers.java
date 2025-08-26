package core_java;

import java.util.Scanner;

public class SumOfTwoNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter 1St Number:- ");
		int a = sc.nextInt();
		
		System.out.println("Please Enter 2nd Number:- ");
		int b = sc.nextInt();
		
		int sum = a + b ;
		System.out.println("The Sum Of The Given Number is :- " + sum);
		sc.close();
	}

}
