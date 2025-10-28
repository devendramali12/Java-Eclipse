package level1;

import java.util.Scanner;

// --> Take a character and check whether it’s uppercase, lowercase, a digit, or a special  character. 

public class Q9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Character");
		char ch = sc.next().charAt(0);

		if (ch >= 48 && ch <= 57) {
			System.out.println(ch + " Is a Digits");
		} else if (ch >= 65 && ch <= 90) {
			System.out.println(ch + " Is a Uppercase Character");
		} else if (ch >= 97 && ch <= 122) {
			System.out.println(ch + " Is a Lowercase Character");

		} else {
			System.out.println(ch + " Is Special Character");
		}
		sc.close();

	}
}
