package logics;

public class SecondMinimumInArray {
	public static void main(String[] args) {
		int[] arr = { 12, 45, 3, 25, 45, 11, 85, 6 };

		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		int sec = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < sec && arr[i] != min) {
				sec = arr[i];
			}
		}
		System.out.println("Second Minimum element in array is " + sec);
	}

}
