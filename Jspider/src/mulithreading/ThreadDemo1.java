package mulithreading;

class MyThread extends Thread {

	public void run() {
		System.out.println("Thread Is Running :- " + Thread.currentThread().getName());
	}

}

public class ThreadDemo1 {
	public static void main(String[] args) {
//		MyThread t1 = new MyThread();
//		t1.start();
//
//		MyThread t2 = new MyThread();
//		t2.start();

		for (int i = 0; i <= 2000; i++) {
			MyThread t = new MyThread();
			t.start();

		}
	}

}
