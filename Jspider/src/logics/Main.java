package logics;

public class Main {
	public static void main(String[] args) {
		int[] arr = { 12, 45, 69, 85, 32, 14, 785, 63 };

		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int sec = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > sec && arr[i] != max) {
				sec = arr[i];
			}
		}
		System.out.println("The Second Maximum element in array is " + sec);
	}

}
