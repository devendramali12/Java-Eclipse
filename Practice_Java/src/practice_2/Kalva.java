package practice_2;

public class Kalva {
	{
		System.out.println("I am near to Thane ");
	}

	{
		System.out.println("Very Dangerous Place To Visit");
	}

	static {
		System.out.println("I am static line");

	}

	public static void main(String[] args) {
		System.out.println("Main Start");
		Kalva k1 = new Kalva();

		System.out.println();
		System.out.println("--------------------------------------");

		Kalva k2 = new Kalva();
		System.out.println();
		System.out.println("---------------------------------------");

		System.out.println();
		Kalva k3 = new Kalva();
		System.out.println();
		System.out.println("Main End");

	}

	static {
		System.out.println("i am 2nd static block");
	}
	{
		System.out.println("last non static block last mai execute hoga");
	}

}
