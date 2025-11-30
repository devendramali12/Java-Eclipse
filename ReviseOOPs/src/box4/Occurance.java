package box4;

public class Occurance {
	public static void main(String[] args) {
		int arr[] = { 4, 1, 2, 78, 96, 3, 2, 56, 3, 2, 4, 5, 6, 31, 2, 556, 3, 27, 8, 96, 3, 2 };

		int key = 3;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				count++;
			}
		}
		System.out.println(key + " Ocuured " + count + " Times");
	}
}
