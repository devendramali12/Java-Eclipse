package polymorphism;

interface AA {
	void show();
}

class BB implements AA {
	@Override
	public void show() {
		System.out.println("B");
	}
}

public class Test2 {
	public static void main(String[] args) {
		AA obj = new BB();
		obj.show();
	}

}
