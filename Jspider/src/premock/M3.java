package premock;

// With Parameter With Return Type
public class M3 {
	public static int mul(int n1, int n2) {

		int n3 = n1 * n2;
		System.out.println("The Multiplication Of Two Number Is :- " + n3);
		return n3;
	}

	public static void main(String[] args) {
		mul(5, 5);

	}

}
