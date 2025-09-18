package box1;

class aamisha {
	static String str1 = "Aajari aste me"; // Static String
	String str2 = "Bari pn hoeil lavkar"; // Non Static String

	static void mulund() { // Static Method
		System.out.println("Wagle Estate op");
	}

	void kalyan() { // Non Static Method
		System.out.println("Metro Mall aao Kabhi");
	}
}

public class nivee {
	public static void main(String[] args) {
//		System.out.println(aamisha.str1);
//		aamisha.mulund();
//
//		System.out.println(new aamisha().str2);
//		new aamisha().kalyan();

		System.out.println(b2.op);
		b2.lonely();

		System.out.println(new b2().op2);
		new b2().duo();

	}

}
