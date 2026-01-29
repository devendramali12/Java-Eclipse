package collectionsframework;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

		map.put(101, "Rahul");
		map.put(102, "Amit");
		map.put(103, "Sneha");

		Thread t1 = new Thread(() -> {
			map.put(104, "Riya");
			System.out.println("Thread 1 Updated Map: " + map);
		});

		Thread t2 = new Thread(() -> {
			map.put(105, "Pooja");
			System.out.println("Thread 2 Updated Map: " + map);
		});

		t1.start();
		t2.start();
	}
}
