package box10;

class daddy {
	int a = 100;

	void work() {
		System.out.println("Hard Work");
	}
}

class son extends daddy {
	int p = 30;

	void study() {
		System.out.println("studying");
	}
}

public class Karanji {
	public static void main(String[] args) {

		daddy d1 = new son(); // --> Upcasting
		System.out.println(d1.a);
		d1.work();

//		System.out.println(d1.p);
//		d1.study();

		System.out.println("--------------------------------");

		son s1 = (son) d1; // --> Downcasting
		System.out.println(s1.a);
		System.out.println(s1.p);
		s1.work();
		s1.study();

	}

}
