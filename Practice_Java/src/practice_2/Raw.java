package practice_2;

class r1 {
	r1() {
		System.out.println("Inside a Constructor");
	}

	{
		System.out.println("Non-Static Block 1 ");
	}

	{
		System.out.println("Non-Static Block 2");
	}

	static {
		System.out.println("Static Block 1");
	}
}

public class Raw {
	public static void main(String[] args) {
		r1 r = new r1();
		System.out.println("--------------------------------------------------");
		r1 rr = new r1();
		System.out.println("--------------------------------------------------");
		r1 ab = new r1();

	}

	static {
		System.out.println("Static Block 2");
	}
}
