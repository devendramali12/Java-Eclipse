package box5;

public class SmallestElements {
	public static void main(String[] args) {
		int[] arr = { 20, 10, 30, 52, 36, 45, 69, 85, 96, 21, 11, 12 };
		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("The Smallest Elements in Array Is :- " + min);
	}

}
