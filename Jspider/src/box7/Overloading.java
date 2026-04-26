package box7;

class add {
	int sum(int a, int b) {
		return a + b;
	}

	int sum(int a, int b, int c) {
		return a + b + c;
	}

	int sum(int a, int b, int c, int d) {
		return a + b + c + d;
	}
}

public class Overloading {
	public static void main(String[] args) {
		add a = new add();
		System.out.println(a.sum(10, 20));
		System.out.println(a.sum(10, 20, 30));
		System.out.println(a.sum(10, 20, 30, 40));
	}

}
