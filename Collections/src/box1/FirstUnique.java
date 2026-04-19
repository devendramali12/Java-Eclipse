package box1;

import java.util.HashMap;
import java.util.LinkedHashMap;

// --> Find First Non-Repeated Character using HashMap
public class FirstUnique {
	public static void main(String[] args) {
		String str = "aabbcdde";

		HashMap<Character, Integer> map = new LinkedHashMap<>();

		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for (char ch : map.keySet()) {
			if (map.get(ch) == 1) {
				System.out.println(ch);
				break;
			}
		}
	}

}
