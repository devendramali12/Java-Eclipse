package com.practice;

public class FibonacciSeries {
	public static void main(String[] args) {
		int num = 10;
		int first = 0;
		int second = 1;
		System.out.print(first + " " + second + " ");

		for (int i = 2; i <= num; i++) {
			int third = first + second;
			System.out.print(third + " ");
			first = second;
			second = third;
		}
	}

}
