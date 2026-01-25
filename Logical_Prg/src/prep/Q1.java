package prep;

// --> "aaabbcc" --> a3b2c2
public class Q1 {
	public static void main(String[] args) {
		String s = "aaabbcc";
		int count = 1;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} else {
				System.out.println(s.charAt(i) + " " + count);
				count = 1;
			}
		}
		// --> Print last character
		System.out.println(s.charAt(s.length() - 1) + "" + count);
	}

}
