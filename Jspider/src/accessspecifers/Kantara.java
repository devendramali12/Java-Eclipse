package accessspecifers;

// Inside Same Class 
public class Kantara {
	public int a = 100; // ---> Public Access
	protected int b = 200; // ---> Protected Access
	int c = 300; // ---> Default Access
	private int d = 400; // ---> Private Access

	// Non Static Methods
	public void test1() {
		System.out.println("1... Public Access Method");
	}

	protected void test2() {
		System.out.println("2... Protected Access Method");
	}

	void test3() {
		System.out.println("3... Pkg-Level Access Method");
	}

	private void test4() {
		System.out.println("4... Private Access Method");
	}

	public static void main(String[] args) {
		System.out.println("Kantara Start");
		Kantara k1 = new Kantara();
		System.out.println(k1.a);
		System.out.println(k1.b);
		System.out.println(k1.c);
		System.out.println(k1.d);

		System.out.println("--------------------------------------------------------");
		k1.test1();
		k1.test2();
		k1.test3();
		k1.test4();

		System.out.println("Kantara End");

	}

}
