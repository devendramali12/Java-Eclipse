package methods;
//With return Type With Parameter

public class ReverseNum {
	public static int reverse(int num) {
		int rev = 0;
		while (num != 0) {
			int last = num % 10;
			rev = (rev * 10) + last;
			num = num / 10;
		}
		System.out.println("The Reverse is " + rev);
		return rev;
	}

	public static void main(String[] args) {
		reverse(1234);

	}

}
