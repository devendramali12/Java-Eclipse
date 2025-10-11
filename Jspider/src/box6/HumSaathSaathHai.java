package box6;

//import box6.Father.Satyam;

class Father {
	void land() {
		System.out.println("100 Acre...");
	}

}

class Satyam extends Father {
}

public class HumSaathSaathHai {
	public static void main(String[] args) {
		System.out.println("Main Start");
		Satyam s1 = new Satyam();
		s1.land();
		System.out.println("Main End");

	}

}
