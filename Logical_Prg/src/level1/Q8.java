package level1;

import java.util.Scanner;

// ---> Take a character and check if it’s a vowel or consonant.
public class Q8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);

		ch = Character.toLowerCase(ch);

		if (ch >= 'a' && ch <= 'z') {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				System.out.println(ch + " is a Vowel");
			} else {
				System.out.println(ch + " is a Consonant");
			}

		} else {
			System.out.println("Please enter a valid alphabet letter");
		}
		sc.close();

	}

}
