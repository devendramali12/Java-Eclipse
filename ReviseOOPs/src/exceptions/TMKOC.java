package exceptions;

// --> Implicit Constructor Call 
class bapuji {
	public bapuji() {
		System.out.println(" 1 :- Chamapaklal");
		// TODO Auto-generated constructor stub
	}
}

class jetha extends bapuji {
//	super();
	public jetha() {
		super();
		System.out.println(" 2 :- Jethalala");
		// TODO Auto-generated constructor stub
	}
}

class tapu extends jetha {
	public tapu() {
		System.out.println(" 3 :-Tapuda");
		// TODO Auto-generated constructor stub
	}
}

public class TMKOC {
	public static void main(String[] args) {
		tapu t1 = new tapu();

	}

}
