package abstraction;

abstract class A {
	A() {
		show();
	}

	abstract void show();
}

class B extends A {
	int x = 10;

//	@Override
	void show() {
		System.out.println(x);
	}
}

public class Test3 {
	public static void main(String[] args) {
		A obj = new B();

	}

}
