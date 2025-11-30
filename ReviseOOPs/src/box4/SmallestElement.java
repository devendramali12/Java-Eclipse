package box4;

public class SmallestElement {
	public static void main(String[] args) {

		int arr[] = { 2, 45, 6, 30, 41, 856, 324, 103, 2563, 50 };

		int small = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < small) {
				small = arr[i];

			}
		}

		System.out.println("Smallest Element in Array is " + small);
	}

}