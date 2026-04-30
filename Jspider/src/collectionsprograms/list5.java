package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;

// --> Reverse ArrayList
public class list5 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40));

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
	}
}
