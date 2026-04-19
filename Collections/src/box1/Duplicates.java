package box1;

import java.util.HashSet;

// --> Find Duplicate Elements in an Array using HashSet

public class Duplicates {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 10, 40, 20 };

		HashSet<Integer> set = new HashSet<>();

		for (int num : arr) {
			if (!set.add(num)) {
				System.out.println("Duplicate :- " + num);
			}
		}
	}

}
