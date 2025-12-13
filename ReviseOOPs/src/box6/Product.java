package box6;

public class Product {

	int id;
	String name;

	public Product(int id, String name) {
		this.id = id;
		this.name = name;

		System.out.println("this: " + this);

	}

	void display() {
		System.out.println("Product id is:- " + id + " Name is:- " + name);
	}
}
