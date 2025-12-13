package box9;

class aaji {
	void love() {
		System.out.println("Love's Every GrandChild");
	}

}

class mummy extends aaji {
	void cook() {
		System.out.println("Love's Cooking Food");
	}

}

class mulgi extends mummy {
	void hard() {
		System.out.println("Hard");

	}
}

public class Main {
	public static void main(String[] args) {
		mulgi m1 = new mulgi();

		m1.cook();
		m1.love();
		m1.hard();

	}

}
