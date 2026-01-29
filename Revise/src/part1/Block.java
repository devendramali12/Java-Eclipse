package part1;

public class Block {

	static {
		System.out.println("Static Block 1");

	}
	{
		System.out.println("Non Static Block 1");
	}

	Block() {
		System.out.println("Constructor");
	}

	public static void main(String[] args) {
		System.out.println("Main Start");
		Block b1 = new Block();
		Block b2 = new Block();
		Block b3 = new Block();
		System.out.println("Main End");
	}

	static {
		System.out.println("Static Block 2");
	}
	{
		System.out.println("Non Static Block 2");
	}

}
