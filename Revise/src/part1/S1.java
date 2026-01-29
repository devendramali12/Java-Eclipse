package part1;

public class S1 {

// --> Static Global Variable
	static int age = 22;
	static String s = "Devendra";

	static void info() {
		System.out.println("My Name is " + s + " Age is " + age);
	}

	public static void main(String[] args) {
		System.out.println(S1.age);
		System.out.println(S1.s);

		S1.info();

		System.out.println(new Hate().age);
	}

}
