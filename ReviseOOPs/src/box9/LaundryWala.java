package box9;

class father {

	String name = "Papa";

	void hardwork() {
		System.out.println("For His Family");
	}

}

class beta extends father {
	void chill() {
		System.out.println("EveryTime Chills");
	}

}

public class LaundryWala {
	public static void main(String[] args) {
		beta b1 = new beta();
		System.out.println(b1.name);
		b1.hardwork();
		b1.chill();
	}

}
