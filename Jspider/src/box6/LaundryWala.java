package box6;

class papa {
	void work() {
		System.out.println("Hard Workings");
	}

	void love() {
		System.out.println("Loves's His Child Will Give All The Belongings to Son");
	}

	void money() {
		System.out.println("Le Le Beta Paise.........");
	}
}

class beta extends papa {
	void enjoy() {
		System.out.println("Baap Ke Paiso Pe Enjoing");
	}
}

class chotabeta extends beta {
	void aayashi() {
		System.out.println("Aajoba ke paise pe enjoy......");
	}
}

public class LaundryWala {
	public static void main(String[] args) {
		beta b1 = new beta();
		b1.work();
		b1.love();
		b1.money();
		b1.enjoy();
		System.out.println("-------------------------------------------------");
		chotabeta c1 = new chotabeta();
		c1.work();
		c1.love();
		c1.money();
		c1.enjoy();
		c1.aayashi();
	}

}
