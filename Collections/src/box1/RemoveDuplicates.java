package box1;

import java.util.ArrayList;
import java.util.HashSet;

// --> Remove Duplicates from ArrayList

public class RemoveDuplicates {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		list.add(10);
		list.add(20);
		list.add(10);
		list.add(30);

		HashSet<Integer> set = new HashSet<>(list);

		System.out.println(set);
	}

}
