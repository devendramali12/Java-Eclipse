package exceptionhandling;

public class Test8 {
	static void method1() {
		int x = 10 / 0; // --> Exception occurs here
	}

	static void method2() {
		method1(); // --> Calling Method1
	}

	static void method3() {
		try {
			method2(); // --> Calling Method 2
		} catch (Exception e) {
			System.out.println("Exception Handled in Method3");
		}
	}

	public static void main(String[] args) {

		method3();
		System.out.println("Programs Continues");
	}

}
