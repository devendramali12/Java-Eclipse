package logics;

public class DuplicateElements {
	public static void main(String[] args) {

		int[] arr = { 1, 4, 6, 5, 2, 1, 7, 2, 1, 2 };

		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			boolean visited = false;

			// Check if already printed
			for (int k = 0; k < i; k++) {
				if (arr[i] == arr[k]) {
					visited = true;
					break;
				}

			}
			if (visited)
				continue;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > 0) {
				System.out.println(arr[i] + " -> " + (count + 1));
			}

		}

	}

}
