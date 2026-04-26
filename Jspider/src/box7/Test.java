package box7;

class A {
	int x = 10; // default
	public int y = 20;
	protected int z = 30;
	private int w = 40;
}

class B extends A {
	void display() {
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
//		System.out.println(w); CTE
	}
}

public class Test {
	public static void main(String[] args) {

		B b = new B();
		b.display();
// --> Even in inheritance, private is NOT accessible.
	}
}
