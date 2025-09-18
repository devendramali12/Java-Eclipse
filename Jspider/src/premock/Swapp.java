package premock;

public class Swapp {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(a);
		System.out.println(b);
		System.out.println("----------------------------------------");

		int temp = a;
		a = b;
		b = temp;

		System.out.println(a);
		System.out.println(b);
	}

}
