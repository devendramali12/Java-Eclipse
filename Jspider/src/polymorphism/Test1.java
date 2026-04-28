package polymorphism;

class A1 {
	void show() {
		System.out.println("A1");
	}

}

class B1 extends A1 {
	void show() {
		System.out.println("B1");
	}

	void display() {
		super.show();
		show();
	}
}

public class Test1 {
	public static void main(String[] args) {
		B1 obj = new B1();
		obj.display();
	}

}
