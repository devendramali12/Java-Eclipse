package objectclass;

// --> After Overriding HashCode()
class robot {

	static int num = 143;

	@Override
	public int hashCode() {
		return num++;
	}
}

public class Test4 {
	public static void main(String[] args) {
		robot r1 = new robot();
		System.out.println(r1.hashCode());

		System.out.println("---------------------------------------------");

		robot r2 = new robot();
		System.out.println(r2.hashCode());
	}
}
