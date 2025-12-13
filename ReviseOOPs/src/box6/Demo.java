package box6;

public class Demo {

	// No-Argument Constructor

	Demo() {
		this(10); // --> Calls Parameterized Constructor
		System.out.println("No-Argument Constructor");
	}

	// 1-Argument Constructor
	Demo(int a) {
		this(10, 20); // --> Calls 2-argument constructor
		System.out.println("1-Argument Constructor");

	}

	// 2-Argument Constructor

	Demo(int a, int b) {
		System.out.println("2-Argument Consturctor: " + a + " ," + b);

	}

}
