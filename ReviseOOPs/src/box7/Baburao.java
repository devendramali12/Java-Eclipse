package box7;

public class Baburao {

	static String name; // --> Static Global Variable
	static int cost;

	static { // --> Static Block 1
		name = "Raju";
		cost = 150;

	}
	static { // --> Static Block 2
		name = " KachraSheth";
		cost = 250;

	}

	public static void main(String[] args) {
		System.out.println("Main Start");
		System.out.println(name);
		System.out.println(cost);
		System.out.println("Main End");
	}

	static { // --> Static Block 3
		name = "LakshmiChitFund";
		cost = 0;

	}

}
