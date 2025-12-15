package abstraction;

abstract class raaz {
	String s;
	int num;

	public raaz(String s, int num) {
		this.s = s;
		this.num = num;
	}

	// --> We Can Write Constructor in Abstract Class
	abstract void kill();
}

class bhediya extends raaz {
	int b;

	public bhediya(String s, int num, int b) {
		super(s, num);
		this.b = b;
	}

	@Override
	void kill() {
		System.out.println("Nakhoon se Marna...");
	}
}

public class HayGarmi {
	public static void main(String[] args) {
		raaz r1 = new bhediya("Devendra", 25, 20);
		r1.kill();
	}
}
