package box5;

public class MaximumOfArray {
	public static void main(String[] args) {
		int[] arr = { 10, 25, 6, 8, 95, 62, 5, 3, 5, 68, 9, 5, 55, 22, 36, 96, 45 };
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("The Maximum Element In Array Is :- " + max);
	}

}
