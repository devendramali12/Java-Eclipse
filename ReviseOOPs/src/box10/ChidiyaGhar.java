package box10;

class animal {
	void sound() {
		System.out.println("All Animal Makes Sound");
	}
}

class dog extends animal {
	@Override
	void sound() {
		System.out.println("Baww Baww");
	}
}

class cat extends animal {
	@Override
	void sound() {
		System.out.println("Bhaww Bhaww");
	}
}

class snake extends animal {
	@Override
	void sound() {
		System.out.println("Hiss Hiss");
	}
}

public class ChidiyaGhar {

	public static void main(String[] args) {
		animal a1 = new dog(); // --> Upcasting
		a1.sound();

	}
}
