package p2;

import p1.A;

class b extends A {
	void show() {
		System.out.println(x);
	}
}

public class Test {
	public static void main(String[] args) {
		b obj = new b();
		obj.show();

		A obj2 = new A();
//		System.out.println(obj2.x);

	}

}
// --> protected works in different package ONLY through inheritance
// --> Not through object reference of parent class.

class c extends A {
	void show() {
		System.out.println(x);
	}
}