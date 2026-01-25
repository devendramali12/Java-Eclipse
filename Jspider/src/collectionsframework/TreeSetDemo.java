package collectionsframework;

import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();

		ts.add(40);
		ts.add(10);
		ts.add(30);
		ts.add(20);
		ts.add(10); // --> Duplicate

		System.out.println("TreeSet :- " + ts);
	}

}
