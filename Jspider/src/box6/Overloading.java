package box6;

// --> Method Overloading Example
public class Overloading {

	public static void add(int a, int b) {
		int c = a + b;
		System.out.println(c);

	}

	public static void add(int a, int b, int c) {
		int d = a + b + c;
		System.out.println(d);
	}

	public static void add(int a, int b, int c, int d) {
		int e = a + b + c + d;
		System.out.println(e);
	}

	public static void add(int a, int b, int c, int d, int e) {
		int f = a + b + c + d + e;
		System.out.println(f);
	}

	public static void main(String[] args) {
		add(10, 20);
		add(10, 20, 30);
		add(10, 20, 30, 40);
		add(10, 20, 30, 40, 50);

	}

}
