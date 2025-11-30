package box2;

public class Domino {
	public static void area(double r) {
		System.out.println("Area () Start");
		double res = r * r;

		System.out.println("Area Of Pizza Is " + res);

		System.out.println("Area () End");
	}

	public static void main(String[] args) {
		System.out.println("Main Start");
		area(10);
		System.out.println("Main End");

	}

}
