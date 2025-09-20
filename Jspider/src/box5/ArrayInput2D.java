package box5;

import java.util.Scanner;

public class ArrayInput2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Total Number Of Rows");
		int rn = sc.nextInt();
		System.out.println("Enter The Total Number Of Columns");
		int cn = sc.nextInt();

		int[][] arr2d = new int[rn][cn];

		System.out.println("-----------------------------");

		// Used To Store Elements in 2D Array

		for (int r = 0; r < rn; r++) {
			for (int c = 0; c < cn; c++) {
				System.out.println("Enter ( " + r + "," + c + " ) Elemnt");
				arr2d[r][c] = sc.nextInt();

			}
			System.out.println();
		}
		System.out.println("-----------------------------------------");

		// Used To Print Elements Of 2D Array
		for (int r = 0; r < rn; r++) {
			for (int c = 0; c < cn; c++) {
				System.out.print(arr2d[r][c] + " ");

			}
			System.out.println();
		}
		sc.close();
	}

}
