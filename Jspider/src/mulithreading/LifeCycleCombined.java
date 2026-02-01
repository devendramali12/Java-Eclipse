package mulithreading;

public class LifeCycleCombined extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Started");

		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);

			// --> Yield control to other threads
			Thread.yield();

			try {
				// sleep for 1 second
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		System.out.println(Thread.currentThread().getName() + " Finished");

	}

	public static void main(String[] args) throws Exception {

		LifeCycleCombined t1 = new LifeCycleCombined();
		t1.setName("Child-Thread");

		t1.start(); // --> New --> Runnable --> Running

		LifeCycleCombined t2 = new LifeCycleCombined();
		t2.start();
		t2.setName("Child-Thread(2)");
		t2.setPriority(3);

		// --> Main Thread Waits for t1 to finish
		t1.join();
		t2.join();

		System.out.println("Main Thread Finished");
	}
}
