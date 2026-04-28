package polymorphism;

class a {
	final int x = 10;
}

class b extends a {
	int x = 20;
}

public class Test5 {
	public static void main(String[] args) {
		a obj = new b();
		System.out.println(obj.x);
	}

}
