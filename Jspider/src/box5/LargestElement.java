package box5;

public class LargestElement {
	public static void main(String[] args) {
		int[] arr = { 10, 25, 65, 63, 45, 82, 96, 63, 65, 98, 4 };
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("The Greatest Element In Array is:- " + max);
	}

}
