package polymorphism;

class Demo {
	void show(Integer a) {
		System.out.println("Integer");
	}

	void show(int a) {
		System.out.println("int");
	}
}

public class Test4 {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.show(10);
	}
}
