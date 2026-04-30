package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;

// --> Minimum Element
public class list3 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 45, 85, 3, 1, 20));

		int min = list.get(0);

		for (int num : list) {
			if (num < min) {
				min = num;
			}
		}
		System.out.println("Smallest Element in Arrays :- " + min);
	}
}
