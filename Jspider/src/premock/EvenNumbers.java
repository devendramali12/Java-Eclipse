package premock;

import java.util.Scanner;

public class EvenNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter a Number to get Even Number");
		int a = sc.nextInt();

		for (int i = 0; i <= a; i += 2) {
			System.out.println(i);
		}
		sc.close();
	}

}
