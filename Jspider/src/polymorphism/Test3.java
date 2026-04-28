package polymorphism;

class X {
	X() {
		show();
	}

	void show() {
		System.out.println("X");
	}
}

class Y extends X {
	int x = 10;

	void show() {
		System.out.println(x);
	}
}

public class Test3 {
	public static void main(String[] args) {
		X obj = new Y();
//		obj.show();
	}

}
