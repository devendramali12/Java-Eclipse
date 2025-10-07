package constructor_1;

//Constructor Chaining

public class Book {
	int isbn;
	String tittle;
	String author;
	double price;
	String genre;

	public Book() {

	}

	public Book(int isbn) {
		this.isbn = isbn;

	}

	public Book(String tittle) {
		this.tittle = tittle;

	}

	public Book(int isbn, String tittle, String author) {

//		this.isbn = isbn;
		this(isbn);
		this.tittle = tittle;
		this.author = author;
	}

	public Book(int isbn, String tittle, String author, double price) {
//		this.isbn = isbn;
//		this.tittle = tittle;
//		this.author = author;
		this(isbn, tittle, author);
		this.price = price;
	}

	public Book(int isbn, String tittle, String author, double price, String genre) {
//		this.isbn = isbn;
//		this.tittle = tittle;
//		this.author = author;
//		this.price=price;
		this(isbn, tittle, author, price);
		this.genre = genre;

	}

	public void display() {
		System.out.println("ISBN: " + isbn);
		System.out.println("Title: " + tittle);
		System.out.println("Author: " + author);
		System.out.println("Price: " + price);
		System.out.println("Genre: " + genre);
		System.out.println();

	}

}
