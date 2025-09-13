package oops;

class StKePass {
	static String s = "pappi de";
	String p = "Yash";

	static void aaja() {
		System.out.println("fatakse");

	}

	void jaldi() {
		System.out.println("Jaldi Aja Bhai");
	}
}

public class Qspider {
	public static void main(String[] args) {
		System.out.println(StKePass.s);
		System.out.println(new StKePass().p);

		StKePass.aaja();
		new StKePass().jaldi();
	}
}
