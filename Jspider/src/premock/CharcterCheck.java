package premock;

public class CharcterCheck {
	public static void main(String[] args) {
		String str = "Devendra ";

		int lowercase = 0;
		int Uppercase = 0;
		int special = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90) {
				Uppercase++;
			} else if (ch >= 97 && ch <= 122) {
				lowercase++;
			} else {
				special++;

			}

		}

		System.out.println("Uppercase = " + Uppercase);
		System.out.println("lowercase = " + lowercase);
		System.out.println("Special = " + special);

	}

}
