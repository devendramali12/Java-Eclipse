package abstraction;

abstract class a {
	a() {
		System.out.println("Abstract class constructor");
	}

	abstract void show();

}

class b extends a {

	@Override
	void show() {
		System.out.println("Method implemented in B");
	}

}

public class Test2 {
	public static void main(String[] args) {
		a obj = new b();
		obj.show();
	}

}
