package box6;

public class Demo1 {

	// 1 No Argument Constructor
	Demo1() {
		this("Devendra");
		System.out.println("No-Arugement Constructor Called");

	}

	Demo1(String s) {
		this("lala", 2500);
		System.out.println(s);
		System.out.println("1-Argument Constructor");
	}

	Demo1(String s, int a) {
		System.out.println(s);
		System.out.println(a);
		System.out.println("2 - Argument Consturctor");
	}

}
