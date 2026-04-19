package logics;

public class DuplicateCounts {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 45, 7, 5, 2, 1 };

		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > 1) {
				System.out.println(arr[i] + " Repeted " + count + " Times");
			}
		}
	}
}
