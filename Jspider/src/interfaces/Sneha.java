package interfaces;

interface shuru {
	public abstract void kill();

	void jump();
}

class isha implements shuru {

	@Override
	public void kill() {
		System.out.println("By Words");

	}

	@Override
	public void jump() {
		System.out.println("Jumping Jump");
	}

}

public class Sneha {
	public static void main(String[] args) {
//	shuru s1 = new shuru();  --> CTE We can not create object of interface

		shuru s1 = new isha();
		s1.jump();
		s1.kill();

	}
}
