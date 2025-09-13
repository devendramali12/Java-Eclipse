package premock;

public class DecisionStatement2 {
	public static void main(String[] args) {
		int marks = 34;

		if (marks < 35) {
			System.out.println("Failed");
		} else if (marks >= 35 && marks <= 60) {
			System.out.println("Second class");
		} else if (marks >= 60 && marks <= 80) {
			System.out.println("First Class");
		} else {
			System.out.println("Desitination");
		}
	}

}
