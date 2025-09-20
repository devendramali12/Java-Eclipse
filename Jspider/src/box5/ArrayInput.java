package box5;

import java.util.Scanner;

public class ArrayInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Size Of Array You Like To Create");
		int size = sc.nextInt();
		int[] arr = new int[size];

		System.out.println("------------------------------------------");

		// for loop used to store elements in Array

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter " + i + " Elements");
			arr[i] = sc.nextInt();

		}
		System.out.println("-------------------------------------------");

		// for loop used to print elements in array
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		sc.close();

	}

}
