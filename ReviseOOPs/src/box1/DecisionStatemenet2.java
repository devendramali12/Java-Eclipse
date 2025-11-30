package box1;

public class DecisionStatemenet2 {
	public static void main(String[] args) {
		int marks = 85;

		if (marks < 35) {
			System.out.println("Failed Hua Hai");
		} else if (marks >= 35 && marks <= 60) {
			System.out.println("Third Class Pass Hua Hai");
		} else if (marks >= 60 && marks <= 80) {
			System.out.println("Second Class");
		} else if (marks >= 80) {
			System.out.println("Topper Hai Tu");
		}
	}

}
