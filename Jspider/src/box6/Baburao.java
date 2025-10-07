package box6;

public class Baburao {

	static String name; // Static Global Variable
	static int cost;
	static { // static block 1
		name = "raju";
		cost = 150;

	}

	static { // Static block 2
		name = "KachraSheth";
		cost = 250;

	}

	public static void main(String[] args) {
		System.out.println("Main Start");
		System.out.println(name); // LakshmiChitFund
		System.out.println(cost); // 2
	}

	static { // Static Block 3
		name = "LakshmiChitFund";
		cost = 2;

	}
}
