package box4;

public class LettersInWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Devendra Mali";
		int ucount = 0;
		int lcount = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90) {
				ucount++;

			} else if (ch >= 90 && ch <= 122) {
				lcount++;

			}
		}
		System.out.println("The Length Of String is " + str.length());
		System.out.println("The Uppercase Letters :- " + ucount);
		System.out.println("The Lowercase Letters :- " + lcount);

	}

}
