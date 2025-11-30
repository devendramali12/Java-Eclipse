package box1;

public class DecisionStatement3 {
	public static void main(String[] args) {

		// --> Advance Switch
		int day = 5;
		switch (day) {
		case 1 -> System.out.println("Sunday");
		case 2 -> System.out.println("Monday");
		case 3 -> System.out.println("Tuesday");
		case 4 -> System.out.println("Wednesday");
		case 5 -> System.out.println("Thursday");
		case 6 -> System.out.println("Friday");
		case 7 -> System.out.println("Satursday");

		}

		// --> Normal Switch

		int day1 = 5;

		switch (day1) {
		case 1:
			System.out.println("Sunday");
			break;
		case 2:
			System.out.println("Monday");
			break;
		case 3:
			System.out.println("Tuesday");
			break;
		case 4:
			System.out.println("Wednesday");
			break;
		case 5:
			System.out.println("Thursday");
			break;
		case 6:
			System.out.println("Friday");
			break;
		case 7:
			System.out.println("Satursday");
			break;
		default:
			System.out.println("Invalid Input");
		}
	}

}
