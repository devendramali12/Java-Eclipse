package core;

class champaklal {
	champaklal(int age) {
		System.out.println("Chamapk");
	}
}

class jethalal extends champaklal {

	jethalal(char ch) {
		super(2);
		System.out.println("Jethalal");
	}
}

class tapulal extends jethalal {
	tapulal(int a) {
		super('a');
		System.out.println("Tapuda");
	}
}

public class ExplicitConstructorCall {
	public static void main(String[] args) {
		tapulal t1 = new tapulal(5);
	}

}
