package box2;

public class Letters {
	public static void main(String[] args) {
		String str = "Devendra";

		int lower = 0;
		int upper = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 65 && ch <= 90) {
				upper++;
			} else if (ch >= 90 && ch <= 122) {
				lower++;
			}
		}
		System.out.println("LowerCase Character " + lower);
		System.out.println("UppperCase Character " + upper);
	}

}
