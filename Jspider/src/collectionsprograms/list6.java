package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;

public class list6 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 10, 20));

		ArrayList<Integer> newlist = new ArrayList<>();

		for (int num : list) {
			if (!newlist.contains(num)) {
				newlist.add(num);
			}
		}
		System.out.println("Without Duplicates :- " + newlist);
	}

}
