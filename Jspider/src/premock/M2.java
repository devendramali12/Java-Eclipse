package premock;
// With parameter without return type

public class M2 {
	public static void SumOfNum(int n1, int n2) {

		int n3 = n1 + n2;
		System.out.println("The SUm Of Given Two Number Is :- " + n3);

	}

	public static void main(String[] args) {
		SumOfNum(10, 10);
	}

}
