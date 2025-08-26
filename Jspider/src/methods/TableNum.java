package methods;

public class TableNum {
	public static int table(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " x " + i + " = " + n * i);

		}
		System.out.println("------------------------------------------");
		return n;
	}

	public static void main(String[] args) {
		table(5);
		table(6);
		table(10);

	}

}
