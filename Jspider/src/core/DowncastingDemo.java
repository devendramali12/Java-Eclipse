package core;

class employee {
	void work() {
		System.out.println("Employee works");
	}
}

class developer extends employee {
	void code() {
		System.out.println("Developer Writes Code");
	}
}

public class DowncastingDemo {
	public static void main(String[] args) {

		// Fore Down-casting First We Have to Up-cast
		employee e = new developer(); // --> up-casting

		// Down-casting (Parent --> Child)
		developer d = (developer) e;
		d.code();
		d.work();
	}

}
