package premock;

public class DecisionStatement3 {
	public static void main(String[] args) {
		int day = 5;

		switch (day) {
		case 1 -> System.out.println("Monday");
		case 2 -> System.out.println("Tuesday");
		case 3 -> System.out.println("Wednesday");
		case 4 -> System.out.println("Thursday");
		case 5 -> System.out.println("Friday");
		case 6 -> System.out.println("Satursday");
		}

		int std = 5;
		switch (std) {
		case 1:
			System.out.println("You are in 1st Standard");
			break;
		case 2:
			System.out.println("You are in Second");
			break;
		case 3:
			System.out.println("You are in third");
			break;
		case 4:
			System.out.println("You are in Fourth");
			break;
		case 5:
			System.out.println("You are in Fith");
			break;
		default:
			System.out.println("Bhut padh liya...");
		}

	}

}
