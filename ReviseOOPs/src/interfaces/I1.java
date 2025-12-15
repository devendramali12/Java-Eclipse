package interfaces;

interface shape {
	void draw();
}

class circle implements shape {
	public void draw() {
		System.out.println("Drawing Circle");
	}
}

class square implements shape {
	public void draw() {
		System.out.println("Drawing Rectangle");
	}
}

public class I1 {
	public static void main(String[] args) {
		shape s1 = new circle();
		s1.draw();

		shape s2 = new square();
		s2.draw();
	}
}
