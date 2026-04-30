package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;

// --> Maximum Element

public class List2 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 50, 30, 40));

		int max = list.get(0);

		for (int num : list) {
			if (num > max) {
				max = num;
			}
		}
		System.out.println("Max =" + max);
	}
}
