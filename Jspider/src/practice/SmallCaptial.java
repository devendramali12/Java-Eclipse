package practice;

public class SmallCaptial {
	public static void main(String[] args) {
		String str = "Deve  ndra";
		int upper = 0;
		int smaller = 0;
		int Special = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90) {
				smaller++;

			} else if (ch >= 90 && ch <= 120) {
				upper++;
			} else {
				Special++;

			}

		}

		System.out.println("Smaller letter = " + smaller);
		System.out.println("Captial Letter = " + upper);
		System.out.println("Others Characters " + Special);

	}

}
