package exceptionn;

import java.util.Scanner;

public class Kaand {
	public static void main(String[] args) {
		System.out.println("Kaand Start");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		int n = sc.nextInt();

		int[] arr = { 20, 65, 75, 90, 80, 35, 40, 60, 12, 55 };
		String s = "Akashay";

		try {
			System.out.println(arr[n]);
			System.out.println(s.charAt(n));
			System.out.println(555 / n);
		} catch (ArithmeticException a1) {
			System.out.println("Gadahv Zero Se Mat Divide Kar");
		} catch (StringIndexOutOfBoundsException s1) {
			System.out.println("String Out Of Bound Ho Raha Hai");
		} catch (ArrayIndexOutOfBoundsException a1) {
			System.out.println("Terrace Pe Jaa Raha Hai Tu");
		} catch (Exception e1) {
			System.out.println("Kuch Toh Gadbad Hai Daya");
		}

		System.out.println("Kaand End");

	}

}
