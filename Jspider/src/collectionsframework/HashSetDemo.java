package collectionsframework;

import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();

		hs.add(40);
		hs.add(2);
		hs.add(20);
		hs.add(10);
		hs.add(36);
		hs.add(250);
		hs.add(40); // --> Duplicate

		System.out.println("HashSet :- " + hs);

		for (int x : hs) {
			System.out.println(x);

		}
	}

}
