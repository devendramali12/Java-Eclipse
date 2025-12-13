package interfaces;

interface tatyavinchu {
	public static final int a = 85;
	int b = 45;

	// --> Automatically variables are public static final

	public abstract void dance();

	void jump();

	// --> Automatically methods are public abstract

}

class ishq { // --> Concrete class

	int i = 76; // --> Non-Static

//	void dance(); 

}

public class Chitti {
	public static void main(String[] args) {
		System.out.println("Main Start");
		System.out.println(tatyavinchu.a);
		System.out.println(tatyavinchu.b);
		System.out.println(new ishq().i);
		System.out.println("Main End");
	}

}
