package core;

class Fatherr {
	void home() {
		System.out.println("2BHK House");
	}
}

class Sonn extends Fatherr {
	void bike() {
		System.out.println("Has a Bike");
	}
}

class daughter extends Fatherr {
	void scooty() {
		System.out.println("Has a Scooty");
	}
}

public class HierarchicalDemo {
	public static void main(String[] args) {
		Sonn s = new Sonn();
		daughter d = new daughter();

		s.home(); // inherited
		s.bike(); // own

		d.home(); // inherited
		d.scooty(); // own

	}

}
