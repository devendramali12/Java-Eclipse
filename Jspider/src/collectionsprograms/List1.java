package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;

// --> Sum of All Elements
public class List1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40));

		int sum = 0;
		for (int num : list) {
			sum = sum + num;
		}
		System.out.println("Sum " + sum);
	}

}
