package box7;

class AA {
	private AA() {
		System.out.println("Constructor");
	}

	static void create() {
		AA obj = new AA();
	}
}

public class Test1 {
	public static void main(String[] args) {

//		AA Obj = new AA();
		AA.create();
	}

}
