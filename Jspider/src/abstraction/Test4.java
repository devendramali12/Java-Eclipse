package abstraction;

interface a1 {
	default void show() {
		System.out.println("Default Method A");
	}
}

class b1 implements a1 {

}

public class Test4 {
	public static void main(String[] args) {
		b1 obj = new b1();
		obj.show();
	}

}
