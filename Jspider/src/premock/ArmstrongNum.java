package premock;

import java.util.Scanner;

public class ArmstrongNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		int num = sc.nextInt();
		int original = num;

		int sum = 0;

		while (num != 0) {
			int last = num % 10;
			sum += last * last * last;
			num = num / 10;

		}
		if (original == sum) {
			System.out.println("Its a ArmStrong Number");
		} else {
			System.out.println("It is not and armstrong number");
		}
		sc.close();

	}

}
