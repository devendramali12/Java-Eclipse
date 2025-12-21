package exceptions;

import java.util.Scanner;

public class Kaand {
	public static void main(String[] args) {
		System.out.println("Kaand Start");

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a Number");
		int n = sc.nextInt();

		int[] arr = { 25, 45, 69, 85, 63, 21, 45, 23, 662, 15 };
		String s = "Akshay";

		try {
			System.out.println(arr[n]);
			System.out.println(s.charAt(n));
			System.out.println(569 / n);
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Uper Jaa Raha Hai Tu");
		} catch (StringIndexOutOfBoundsException s1) {
			System.out.println("String Choti Hai");
		} catch (ArithmeticException a) {
			System.out.println("Zero Se Divide Mat Kar");
		} catch (Exception e) {
			System.out.println("Kucj Toh Goad Bad Hai");
		} finally {
			sc.close();
		}

		System.out.println("Kaand End");
	}

}
