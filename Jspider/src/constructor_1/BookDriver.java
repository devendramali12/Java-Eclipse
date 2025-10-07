package constructor_1;

// Constructor Chaining

public class BookDriver {
	public static void main(String[] args) {
		Book b1 = new Book(12345, "Shyamchi Aai", "Sane Guruji", 150, "Biography");
		b1.display();

		Book b2 = new Book(250, "Biography", "SaneGuruji");
		b2.display();
	}

}
