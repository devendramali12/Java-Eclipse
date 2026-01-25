package collectionsframework;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
	public static void main(String[] args) {

		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		lhs.add(40);
		lhs.add(10);
		lhs.add(30);
		lhs.add(20);
		lhs.add(10); // --> Duplicate

		System.out.println("LinkedHashSet :- " + lhs);
	}

}
