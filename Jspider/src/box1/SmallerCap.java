package box1;

public class SmallerCap {
	public static void main(String[] args) {
		String str = "Bala";
		int lower = 0;
		int cap = 0;
		int spec = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90) {
				lower++;
			} else if (ch >= 90 && ch <= 120) {
				cap++;
			} else {
				spec++;
			}
		}
		System.out.println(lower);
		System.out.println(cap);
		System.out.println(spec);
	}

}
