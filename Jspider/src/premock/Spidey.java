package premock;

class anjali {
	static String str = "Babu";
	String str2 = "Sona";

	static void name() {
		System.out.println("Devendra");
	}

	void naav() {
		System.out.println("Bala");
	}
}

public class Spidey {

	public static void main(String[] args) {
		System.out.println(anjali.str);
		System.out.println(new anjali().str2);

		anjali.name();
		new anjali().naav();
	}

}
