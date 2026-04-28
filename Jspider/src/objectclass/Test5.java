package objectclass;
// --> Before Overriding equals()

class Modak {
	String fill;
	int size;

	public Modak(String fill, int size) {
		this.fill = fill;
		this.size = size;
	}
}

public class Test5 {
	public static void main(String[] args) {
		Modak m1 = new Modak("Coconut", 10);
		Modak m2 = new Modak("Coconut", 10);

		System.out.println(m1.equals(m2)); // --> ByDefault equals Compare address of 2 object

		System.out.println("--------------------------------------------------");

		System.out.println(m1 == m2); // --> Always False
	}

}
