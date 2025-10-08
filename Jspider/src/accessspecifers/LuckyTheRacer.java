package accessspecifers;

public class LuckyTheRacer {
	public static void main(String[] args) {
		System.out.println("LuckyTheRacer Start");

		Kantara m1 = new Kantara();
		System.out.println(m1.a);
		System.out.println(m1.b);
		System.out.println(m1.c);
//		System.out.println(m1.d); ---> The field Kantara.d is not visible

		System.out.println("-------------------------------------------------------");
		m1.test1();
		m1.test2();
		m1.test3();
//		m1.test4(); ---> The method test4() from the type Kantara is not visible
		System.out.println("LuckyTheRacer End");
	}

}
