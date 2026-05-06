package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// --> Frequency of Each Element

public class list7 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 10, 30, 20, 10));

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : list) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		System.out.println("Frequency :- " + map);
	}

}
