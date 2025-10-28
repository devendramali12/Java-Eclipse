package practice_2;

class bala {
	private int a = 10;
	private int b = 20;

	public bala(int a, int b) {
		this.a = a;
		this.b = b;

	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

}

public class Lala {
	public static void main(String[] args) {
		bala b1 = new bala(10, 20);
		System.out.println(b1.getA());
		System.out.println(b1.getB());

		System.out.println("---------------------------");

//		System.out.println(b1.setA(20));
		b1.setA(50);
		b1.setB(60);

		System.out.println(b1.getA());
		System.out.println(b1.getB());
	}

}
