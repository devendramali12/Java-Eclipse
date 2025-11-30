package box1;

public class GmailLogin {
	public static void main(String[] args) {
		String str = "devendraa.mali12@gmail.com";
		int pass = 12345;

		if (str == "devendraa.mali12@gmail.com") {
			if (pass == 12345) {
				System.out.println("Login Successful");
			} else {
				System.out.println("Wrong Password");
			}
		} else {
			System.out.println("Invalid Email ID");
		}
	}

}
