package interfaces;

// --> Multiple Classes Implementing Same Interface
interface shape {
	void draw();
}

class circle implements shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle");
	}

}

class square implements shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Square");
	}

}

public class Test3 {
	public static void main(String[] args) {

		shape s = new circle();
		s.draw();
		shape s1 = new square();
		s1.draw();
	}
}
