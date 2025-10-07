package constructor_1;

public class Laptop {
	String brand;
	String processor;
	int ram;
	double price;

	// --> Default Constructor

	public Laptop() {
		System.out.println("Default Constructor called...");
	}

	// --> Constructor With Brand
	public Laptop(String brand) {
		this(); // --> Calls Default Constructor
		this.brand = brand;

	}

	// --> Constructor With Brand + Processor
	public Laptop(String brand, String processor) {
		this(brand); // --> calls constructor with brand
		this.processor = processor;

	}

// --> Constructor With Brand + Processor + Ram
	public Laptop(String brand, String processor, int ram) {
		this(brand, processor); // --> Calls Constructor with brand and processor
		this.ram = ram;
	}

// ---> Constructor With all Fields 
	public Laptop(String brand, String processor, int ram, double price) {
		this(brand, processor, ram); // -->Calls Constructor With 3 Parameter
		this.price = price;
	}

	public void display() {
		System.out.println("Barnd :- " + brand);
		System.out.println("Processor :- " + processor);
		System.out.println("RAM :- " + ram);
		System.out.println("Price :- " + price);
		System.out.println("----------------------------------------------------------");
	}
}
