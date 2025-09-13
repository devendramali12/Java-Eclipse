package premock;

public class OccurenceInArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 45, 6, 5, 6, 3, 2, 8, 7, 8, 9, 5, 2, 2, 3, 7, 5, 5, 4, 2, 2, 2, 2, 2, 2 };
		int key = 2;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				count++;

			}
		}
		System.out.println(key + " Is Occured " + count + " Times");
	}

}
