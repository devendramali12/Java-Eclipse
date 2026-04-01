package com.practice;

public class SecondMaximumInArray {
	public static void main(String[] args) {
		int[] arr = { 15, 12, 45, 85, 96, 45, 75, 63, 86 };
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int second = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > second && arr[i] != max) {
				second = arr[i];
			}
		}
		System.out.println("The Second Maximum Element in Array is " + second);
	}

}
