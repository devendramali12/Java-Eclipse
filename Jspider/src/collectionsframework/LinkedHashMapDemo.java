package collectionsframework;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

		map.put(101, "Rahul");
		map.put(102, "Amit");
		map.put(103, "Sneha");
		map.put(104, "Raja");
		map.put(105, "Rani");

		System.out.println("LinkedHashMap Elements :- " + map);

		System.out.println(map.keySet());

		for (Integer key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}

	}

}
