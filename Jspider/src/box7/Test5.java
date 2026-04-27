package box7;

class A1 {
	int x = 10;

	void show() {
		System.out.println("A");
	}
}

class B1 extends A1 {
	int x = 20;

	void show() {
		System.out.println("B");
	}

}

public class Test5 {
	public static void main(String[] args) {
		A1 obj = new B1();
		System.out.println(obj.x);
		obj.show();

	}

}
