package box7;

class son {
	void born() {
		System.out.println("Son is born");
	}
}

class dad {
	private son s;

	dad() {
		s = new son();
	}

	void work() {
		s.born();
		System.out.println("Dad is Working For Son");
	}
}

public class Test4 {
	public static void main(String[] args) {
		dad d = new dad();
		d.work();
	}

}
