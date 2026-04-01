package com.practice;

public class SumOfArrayElements {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("The Sum Of Array Elements is " + sum);
	}

}
