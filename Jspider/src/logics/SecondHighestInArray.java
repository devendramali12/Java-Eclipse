package logics;

public class SecondHighestInArray {
	public static void main(String[] args) {
		int[] arr = { 12, 45, 85, 69, 89, 96, 32, 10 };

		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

		}
//		System.out.println(max);
		int second = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > second && arr[i] != max) {
				second = arr[i];

			}

		}
		System.out.println("The Second Minimum Element in Array is " + second);
	}

}
