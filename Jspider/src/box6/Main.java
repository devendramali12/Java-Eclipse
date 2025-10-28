package box6;
// --> Multi-Level Inheritance

class granny {
	void love() {
		System.out.println("Dadi Ka Pyarr");
	}
}

class mom extends granny {
	void care() {
		System.out.println("Caring......");
	}
}

class beti extends mom {
	void kalesh() {
		System.out.println("KamChor Beti...");
	}
}

public class Main {
	public static void main(String[] args) {
		System.out.println("Main Start");

		mom m1 = new mom();
		m1.care();
		m1.love();

		System.out.println("----------------------");

		beti b1 = new beti();
		b1.care();
		b1.kalesh();
		b1.love();

		System.out.println("Main End");
	}

}
