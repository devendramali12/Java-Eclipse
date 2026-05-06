package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 10, 20, 30));
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : list) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		System.out.println(map);
	}

}
