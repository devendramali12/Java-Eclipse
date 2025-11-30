package box2;

// --> Write Program To find Marks of student who is studying 6 Sub using Method

public class Q1 {

	public static void main(String[] args) {
		sub(10, 20, 30, 40, 50, 60);

	}

	public static void sub(int a, int b, int c, int d, int e, int f) {
		int sum = a + b + c + d + e + f;
		int avg = sum / 6;
		System.out.println("Average Marks Of Student In 6 Subject Is " + avg);

	}

}
