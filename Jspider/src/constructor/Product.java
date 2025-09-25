package constructor;
// Parameterized Constructor

public class Product {
	int id;
	String name;

	public Product(int pid, String name) {
		this.id = pid;
		this.name = name;
		System.out.println("this " + this);

	}

	void info() {
		System.out.println("ID is " + id + " Name :- " + name);

	}

}
