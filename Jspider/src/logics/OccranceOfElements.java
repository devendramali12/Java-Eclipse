package logics;

public class OccranceOfElements {
	public static void main(String[] args) {
		int[] arr = { 2, 45, 63, 11, 20, 36, 20, 45, 63, 20, 45, 63 };

		int num = 20;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				count++;
			}
		}
		System.out.println(num + " Is Occured " + count + " Times");
	}

}
