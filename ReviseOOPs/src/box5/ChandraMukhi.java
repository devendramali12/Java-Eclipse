package box5;

class Rakhi {
	String r = " Zinda hu";

	void kalesh() {
		System.out.println("Kalesh Method");
	}
}

public class ChandraMukhi {

	int a = 20; // --> Non Static Global Variable

	void hawan() { // --> Non Static Method
		System.out.println("Hawan Karenge....");
	}

	public static void main(String[] args) {

		System.out.println(new Rakhi().r);
		new Rakhi().kalesh();

		System.out.println("------------------------------------");

		System.out.println(new ChandraMukhi().a);
		new ChandraMukhi().hawan();

		System.out.println("--------------------------------------");

		System.out.println(new Basnati().d);
		new Basnati().nachna();
	}

}
