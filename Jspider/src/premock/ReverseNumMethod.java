package premock;

public class ReverseNumMethod {
	public static void ultanum(int num) {
//		Scanner sc = new Scanner(System.in);
		int rev = 0;
//		System.out.println("Please Enter a Number");
		System.out.println("The Given Number is " + num);
//		int num = sc.nextInt();
		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num /= 10;
		}
		System.out.println("The Reversed Number Is :- " + rev);
//		sc.close();

	}

	public static void main(String[] args) {
		ultanum(1234);
		ultanum(4125);

	}

}
