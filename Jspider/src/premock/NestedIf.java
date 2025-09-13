package premock;

public class NestedIf {
	public static void main(String[] args) {

		String str = "dmali9198@gmail.com";
		int pass = 1234;
		if (str == "dmali9198@gmail.com") {
			if (pass == 1234) {
				System.out.println("Login Successfull");
			} else {
				System.out.println("Wrong Password");
			}
		} else {
			System.out.println("Invalid Email ID");
		}
	}

}
