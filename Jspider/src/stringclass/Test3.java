package stringclass;

class tesla {

}

public class Test3 {
	public static void main(String[] args) {
		tesla t1 = new tesla();
		tesla t2 = new tesla();

		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());

		System.out.println("------------------------------------------------");

		String s1 = "Java";
		String s2 = "Java";

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}

}
