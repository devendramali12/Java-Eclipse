package exceptionn;

import java.util.Scanner;

public class SnehaApartment {
	public static void main(String[] args) {
		System.out.println("Main Start");

		int[] arr = { 20, 50, 70, 80, 50, 90, 10, 20, 40 };

		// --> Array Length = 10
		// --> Index = 0-9

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Te Index To Get Element");
		int ind = sc.nextInt();

		try {
			System.out.println("Element in index " + ind + " Is :- " + arr[ind]);

		} catch (ArrayIndexOutOfBoundsException e1) {

			System.out.println("Terrace Pe Ja Raha Hai Tu Neeche Aja..");
		}
		System.out.println("Main End");
		sc.close();
	}

}
