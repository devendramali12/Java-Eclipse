package practice;

public class SmallestElement {
	public static void main(String[] args) {
		int[] arr = { 900, 25, 45, 65, 96, 85, 78, 95, 63 };
		int samllest = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < samllest) {
				samllest = arr[i];

			}
		}
		System.out.println("The smallest element in array is " + samllest);

	}

}
