package mulithreading;

class NumberThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}

public class TwoThreadDemo {
	public static void main(String[] args) {
		NumberThread t1 = new NumberThread();
		NumberThread t2 = new NumberThread();

		t1.start();
		t2.start();

	}
}
