package methods;
//Without Return Type With Parameter

public class Method2 {
	public static void add(int num1, int num2) {
		System.out.println("The 1st Number is " + num1);
		System.out.println("The 2nd Number is " + num2);
		int sum = num1 + num2;
		System.out.println("Sum Of The Given Two Number is " + sum);
		System.out.println("-------------------------------------------------------------");
	}

	public static void main(String[] args) {
		add(20, 30);

		add(20, 10);

	}
}
