package box1;

import java.util.ArrayList;
import java.util.Collections;

// --> Reverse an ArrayList
public class ReverseList {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);

		System.out.println(list);

		Collections.reverse(list);

		System.out.println(list);
	}

}
