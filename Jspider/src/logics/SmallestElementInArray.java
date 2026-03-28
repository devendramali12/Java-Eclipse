package logics;

public class SmallestElementInArray {
	public static void main(String[] args) {
		int[] arr = { 45, 2, 5, 2, 2, 3, 5, 1, 4, 52, 35, 4 };

		int small = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < small) {
				small = arr[i];
			}
		}
		System.out.println("The Smallest Element in Array is " + small);
	}

}
