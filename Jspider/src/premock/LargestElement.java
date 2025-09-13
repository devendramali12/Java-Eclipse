package premock;

public class LargestElement {
	public static void main(String[] args) {
		int[] num = { 20, 36, 56, 98, 85, 75, 69, 6, 5, 2, 455, 2, 52, 3, 2, 5, 41, 2, 10 };
		int max = num[0];

		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		System.out.println("Largest Element In a Array Is :- " + max);
	}

}
