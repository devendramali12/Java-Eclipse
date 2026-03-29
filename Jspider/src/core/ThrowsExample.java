package core;

public class ThrowsExample {

	static void checkAge(int age) throws Exception {
		if (age < 18) {
			throw new Exception("Not Eligible for voting");
		} else {
			System.out.println("Eligible for voting");
		}
	}

	public static void main(String[] args) {
		try {
			checkAge(16);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
