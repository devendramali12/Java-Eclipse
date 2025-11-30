package box4;

public class LargestElement {
	public static void main(String[] args) {
		int arr[] = { 15, 45, 85, 0, 12, 36, 523, 123, 54, 145, 2 };

		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("Maximum Element In Array Is " + max);
	}

}
