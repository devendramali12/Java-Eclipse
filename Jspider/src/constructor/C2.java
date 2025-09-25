package constructor;

// Accessing Static and Non Static Members Of A Class

class bajuvala {
	String name = "Ramesh"; // Non Static Global Variable
	int age = 27;

	void info() { // Non Static method
		System.out.println("My Name Is " + name + " & Age is " + age);
	}
}

class aunty {
	static String name = "Sexyaunty";
	static int age = 35;

	void deatils() {
		System.out.println("Name is " + name + " Age is " + age);
	}

}

public class C2 {
	public static void main(String[] args) {
		bajuvala b1 = new bajuvala();
		System.out.println(new bajuvala().age);
		System.out.println(new bajuvala().name);
		b1.info();

		System.out.println();
		System.out.println();

		aunty a1 = new aunty();

		System.out.println(aunty.age);
		System.out.println(aunty.name);
		a1.deatils();

	}

}
