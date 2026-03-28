package logics;
// --> WAP 2nd Largest Element in Array

public class SecondLargest {
	public static void main(String[] args) {

		int[] arr = { 10, 20, 45, 30, 45, 50 };

		// Step 1: Find largest
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// Step 2: Find second largest
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > second && arr[i] != max) {
				second = arr[i];
			}
		}

		System.out.println("Second Largest: " + second);

	}

}
