package com.practice;

public class FactoRecurssion {

	public static int fact(int num) {
		if (num == 0) {
			return 1;
		}
		return num * fact(num - 1);
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(n + " factorial is " + fact(n));
	}

}
