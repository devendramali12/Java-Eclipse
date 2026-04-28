package abstraction;

interface x {
	default void show() {
		System.out.println("X");
	}
}

interface y {
	default void show() {
		System.out.println("Y");
	}
}

class C implements x, y {
	public void show() {
		x.super.show();
	}
}

public class Test5 {
	public static void main(String[] args) {
		C obj = new C();
		obj.show();

	}

}
