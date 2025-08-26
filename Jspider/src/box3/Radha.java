package box3;

import java.util.Scanner;

public class Radha {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter Your Name:-");
		String name = sc.nextLine();
		
		System.out.println("Enter Div:-");
		char div = sc.next().charAt(0);
		
		System.out.println("Enter Number");
		long num = sc.nextLong();
		
		System.out.println("Enter Percentage");
		float per = sc.nextFloat();
		
		System.out.println("------------------------------------------------------");
		System.out.println(name);
		System.out.println(div);
		System.out.println(num);
		System.out.println(per);
		
		
		sc.close();
	}

}
