package part1;

public class Hate {

	// --> Global Variable

	public int age = 22;
	String name = "Devendra";

	public static void main(String[] args) {

		// --> Local Variable
		int size = 5;
		String s = "Huge";

		Hate h1 = new Hate();

		System.out.println(h1.age);
		System.out.println(h1.name);

		System.out.println(new Hate().age);
		System.out.println(new Hate().name);

		System.out.println(size);
		System.out.println(s);
	}

}
