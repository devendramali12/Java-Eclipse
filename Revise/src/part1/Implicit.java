package part1;

class bapuji extends Object {
	bapuji(String s) {
		System.out.println("Jetha Ke Baap");
	}
}

class jetha extends bapuji {

	jetha(int age) {
		super("lala");
		System.out.println("tapu Ke papa");
	}
}

class tapu extends jetha {

	tapu(double per) {
		super(5);
		System.out.println("Tapuda");
	}
}

public class Implicit {
	public static void main(String[] args) {
		tapu t1 = new tapu(56.36);
		System.out.println("--------------------------------------------");

		jetha j1 = new jetha(5);
	}

}
