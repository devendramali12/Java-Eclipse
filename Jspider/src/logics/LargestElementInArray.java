package logics;

public class LargestElementInArray {
	public static void main(String[] args) {
		int[] arr = { 25, 45, 78, 6, 5, 9, 78, 95 };

		int large = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > large) {
				large = arr[i];
			}
		}
		System.out.println("The Largest Element in Array is " + large);
	}

}
