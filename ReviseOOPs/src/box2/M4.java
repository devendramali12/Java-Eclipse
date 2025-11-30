package box2;

public class M4 {
	public static int avg(int a, int b, int c) {
		int sum = a + b + c;
		int avg = sum / 3;
		System.out.println(avg);
		return avg;
	}

	public static void main(String[] args) {
		avg(10, 20, 30);

	}

}
