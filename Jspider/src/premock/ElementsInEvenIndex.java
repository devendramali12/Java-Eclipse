package premock;

public class ElementsInEvenIndex {
	public static void main(String[] args) {
		int[] arr = { 11, 21, 31, 41 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				sum = sum + arr[i];
			}
		}
		System.out.println("Sum " + sum);

	}

}
