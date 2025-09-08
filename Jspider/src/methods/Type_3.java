package methods;

// With Return Type Without Parameter
import java.util.Scanner;

public class Type_3 {
	public static int sum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter First Number");
		int num1 = sc.nextInt();

		System.out.println("Please Enter Second Number");
		int num2 = sc.nextInt();

		int num3 = num1 + num2;
		System.out.println("The Sum Of Two Number is :- " + num3);

		sc.close();

		return num3;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sum();

	}

}
