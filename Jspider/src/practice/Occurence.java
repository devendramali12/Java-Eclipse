package practice;

public class Occurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 3, 6, 4, 7, 8, 5, 2, 1, 2, 3, 6, 5, 4, 78, 9 };
		int key = 2;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				count++;
			}
		}
		System.out.println(key + " Is Repeated " + count);

	}

}
