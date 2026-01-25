package collectionsframework;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<String>();

		a1.add("Devendra");
		a1.add("Gian");
		a1.add("Ram");
		a1.add("Lala");

		System.out.println(a1);

		ArrayList<Integer> a2 = new ArrayList<Integer>();

		a2.add(22);
		a2.add(63);
		a2.add(452);
		a2.add(690);

		System.out.println(a2);
		System.out.println(a1.getLast());
	}

}
