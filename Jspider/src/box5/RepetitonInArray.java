package box5;

public class RepetitonInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 4, 5, 8, 9, 5, 4, 2, 3, 6, 4, 5, 5, 6, 7, 8, 5 };
		int key = 3;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				count++;

			}

		}
		System.out.println(key + " Is Repeated " + count + " Times");

	}

}
