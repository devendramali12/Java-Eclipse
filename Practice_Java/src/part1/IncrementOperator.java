package part1;

public class IncrementOperator {
	public static void main(String[] args) {
		{
			// Case --> 1
			int a = 10;
			a++;
			System.out.println(a);

			// Case --> 2
			int b = 10;
			System.out.println(b++);
			System.out.println(b);

			// Case --> 3
			int c = 10;
			c = c++;
			System.out.println(c);

			// InCase oF post increment operator 1st use the value
			// then increment the value
		}
		System.out.println();
		System.out.println();
		System.out.println();
		{
			// Case --> 1
			int a = 10;
			++a;
			System.out.println(a); // 11

			// Case --> 2
			int b = 10;
			System.out.println(++b); // 11
			System.out.println(b); // 11

			// Case --> 3
			int c = 10;
			++c;
			System.out.println(c); // 11

			// In Case of prefix increment operator 1st increment
			// the value then use value

		}
	}

}
