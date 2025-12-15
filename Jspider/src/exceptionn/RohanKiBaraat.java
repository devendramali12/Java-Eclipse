package exceptionn;

public class RohanKiBaraat {
	public static void main(String[] args) {
		System.out.println("r Start");
		try {
			jadoo();
		} catch (InterruptedException a1) {
			System.out.println("Handled");
		}
	}

	public static void jadoo() throws InterruptedException, ArithmeticException {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			Thread.sleep(350);
		}
	}

}
