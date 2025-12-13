package box9;

class Champaklal extends Object {
	Champaklal() {
		System.out.println("1 --> Inside Chamapk Constructor");

	}

}

class jethalal extends Champaklal {
	jethalal() {
		System.out.println("2 --> Inside Jethalal Constructor");
	}

}

class tapu extends jethalal {
	tapu() {
		System.out.println("3 --> Inside tapu Constructor");
	}

}

public class Tmkoc {
	public static void main(String[] args) {
		System.out.println("TMKOC Start");
		tapu t1 = new tapu();
		System.out.println("TMKOC End");

	}

}
