package collectionsframework;

import java.util.HashMap;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(101, "Rahul");
		map.put(102, "Amit");
		map.put(103, "Sneha");
		map.put(104, "Priya");

		System.out.println(map.get(102));

		System.out.println(map.isEmpty());
	}
}
