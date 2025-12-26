package exceptions;

class bapuji1 {
	// Excplicit Constructor Call
	public bapuji1(String s) {
		System.out.println(" 1 --> Baap of Bapp");
		// TODO Auto-generated constructor stub
	}
}

class jetha1 extends bapuji1 {
	public jetha1(int a) {
		super("lala");
		System.out.println(" 2 --> Owner Of Gada Electronics");
		// TODO Auto-generated constructor stub
	}
}

class tapu1 extends jetha1 {
	public tapu1(int age) {
		super(69);
		System.out.println(" 3 --> Student");

		// TODO Auto-generated constructor stub
	}
}

public class TMKOC1 {
	public static void main(String[] args) {
		tapu1 t = new tapu1(66);
	}

}
