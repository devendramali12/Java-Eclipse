package interfaces;

interface gaurav {
	public abstract void love();

	void party();

	static void dance() {
		System.out.println("Lavni");

	}

	default void color() {
		System.out.println("White");
	}
}

interface akshay {

	void love();

	void party();

}

interface vishal {
	void love();
}

class kunal {
	void ghar() {
		System.out.println("Big House");
	}

	void gold() {
		System.out.println("10 Kg Sona");
	}
}

class skashi extends kunal implements akshay, gaurav, vishal {

	@Override
	public void love() {
		System.out.println("Sakshi Controlling Both Pyaar");
	}

	@Override
	public void party() {
		System.out.println("Sakshi Controlling Both Party");

	}

}

public class BirthdayParty {
	public static void main(String[] args) {

		gaurav g1 = new skashi();
		g1.love();
		g1.party();
	}

}
