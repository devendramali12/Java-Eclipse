package premock;

public class SmallCapitalLetters {
	public static void main(String[] args) {
		String str = "Devendra";

		int small = 0;
		int cap = 0;
		int spec = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 60 && ch <= 90) {
				small++;
			} else if (ch >= 90 && ch <= 120) {
				cap++;
			} else {
				spec++;

			}
		}

		System.out.println("Small letters " + small);
		System.out.println("Capital Letters " + cap);
		System.out.println("Special Letters " + spec);
	}

}
