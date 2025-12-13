package box9;

class fatherr {
	void land() {
		System.out.println("100 Acre");
	}

}

class betaa extends fatherr {
	@Override
	void land() {
		System.out.println("Sab Bech Diya");
	}

}

public class KumkumBhagya {
	public static void main(String[] args) {
		betaa b1 = new betaa();
		b1.land();
		System.out.println("------------------------------------------------------------");
		fatherr f1 = new fatherr();
		f1.land();
	}

}
