package part1;

public class DecisionStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 20;
		if (age >= 18) {
		}

		int marks = 45;
		if (marks >= 35) {
			System.out.println("You Passed");
		} else {
			System.out.println("Failed");
		}

		int std = 12;
		if (std <= 10 && std >= 1) {
			System.out.println("You Are In School");
		} else if (std >= 11 & std <= 12) {
			System.out.println("You Are In Junior College");
		} else {
			System.out.println("You Are In Degree College");
		}

		int Day = 5;
		switch (Day) {

		case 1 -> System.out.println("Monday");
		case 2 -> System.out.println("Tuesday");
		case 3 -> System.out.println("Thursday");
		case 4 -> System.out.println("Friday");
		case 5 -> System.out.println("Satursday");

		}

		String str = "dmali9198@gmail.com";
		int pass = 1234;
		if (str == "dmali9198@gmail.com") {
			if (pass == 1234) {
				System.out.println("LogIn Succcessful");
			} else {
				System.out.println("Wrong Password");
			}
		}

	}

}
