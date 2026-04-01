package com.practice;

public class RevserString {
	public static void main(String[] args) {
		String str = "lalu";
		String rev = "";

		for (int i = 0; i < str.length(); i++) {
			rev = str.charAt(i) + rev;
		}
		System.out.println("The revsered Of a String " + rev);
	}

}
