package box3;

import java.util.Scanner;

public class Maramari {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter The Number :-");
		int a = sc.nextInt();
		
		for(int i = 1; i <=10; i++) {
			int b = i*a;
			System.out.println(b);
		}sc.close();
	}


}
