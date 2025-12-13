package box9;

class champak extends Object {

	champak(String s) {

		System.out.println("Champaklal");

	}

}

class jetha extends champak {
	jetha(int a) {
		super("Lala");
		System.out.println("Jethalal");
	}

}

class taapu extends jetha {
	taapu(char ch) {
		super(5);
		System.out.println("Tapuda");
	}
}

public class TMKOCC {
	public static void main(String[] args) {
		taapu t1 = new taapu('z');
	}

}
