package com.practice;

public class ConsosnantVowel {
	public static void main(String[] args) {
		String str = "Hello World";
		str = str.toLowerCase();
		int vowel = 0, consonant = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z') { // Only letters
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					vowel++;
				} else {
					consonant++;
				}
			}
		}
		System.out.println("The Vowels Count is " + vowel + " Consonant Count is " + consonant);
	}

}
