package objectclass;
// --> Before Overriding HashCode()

class Robot {

}

public class Test3 {
	public static void main(String[] args) {
		Robot r1 = new Robot();
		System.out.println(r1.hashCode());

		System.out.println("--------------------------------------");
		Robot r2 = new Robot();
		System.out.println(r2.hashCode());
	}
}
