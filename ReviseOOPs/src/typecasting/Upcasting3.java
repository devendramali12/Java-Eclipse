package typecasting;

class shape {
	void draw() {
		System.out.println("Drawing Shape");
	}

}

class circle extends shape {
	@Override
	void draw() {
		System.out.println("Drawing Circle");
	}
}

class square extends shape {
	void draw() {
		System.out.println("Drawing Square");
	}
}

public class Upcasting3 {
	public static void main(String[] args) {
		shape[] shapes = { new circle(), new square() };

		for (shape s : shapes) {
			s.draw();
		}
	}

}
