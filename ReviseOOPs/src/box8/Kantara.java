package box8;

public class Kantara {
	public int a = 100; // --> Public Access
	protected int b = 200; // --> Protected Access
	int c = 300; // --> Default Access
	private int d = 400; // --> Private Access

	// --> Non-Static Method
	public void test1() {
		System.out.println("1 --> Public Access Methods");
	}

	protected void test2() {
		System.out.println("2 --> Protected Access Method");

	}

	void test3() {
		System.out.println("3 --> Pkg-Level Access");
	}

	private void test4() {
		System.out.println("4 --> Private-Level Access");

	}

	public static void main(String[] args) {
		Kantara k1 = new Kantara();

		System.out.println(k1.a);
		System.out.println(k1.b);
		System.out.println(k1.c);
		System.out.println(k1.d);

		System.out.println("----------------------------------------------------------");

		k1.test1();
		k1.test2();
		k1.test3();
		k1.test4();
	}

}
