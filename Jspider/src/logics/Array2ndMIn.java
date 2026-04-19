package logics;

public class Array2ndMIn {
	public static void main(String[] args) {
		int[] arr = { 12, 20, 36, 54, 78, 52, 3, 65, 45 };

		int min = arr[0];
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int sec = Integer.MAX_VALUE;
		int secc = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < sec && arr[i] != min) {
				sec = arr[i];
			}
			if (arr[i] > secc && arr[i] != max) {
				secc = arr[i];
			}
		}
		System.out.println("2nd Minimum Number is " + sec);
		System.out.println("2nd Maximum Number is " + secc);
	}

}
