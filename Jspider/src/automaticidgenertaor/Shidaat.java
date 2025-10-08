package automaticidgenertaor;

import accessspecifers.Kantara;

public class Shidaat {
	public static void main(String[] args) {
		System.out.println("Shiddat Start");
		Kantara r1 = new Kantara();
		System.out.println(r1.a);
//		System.out.println(r1.b); --> The field Kantara.b is not visible
//		System.out.println(r1.c);--> The field Kantara.c is not visible
//		System.out.println(r1.d);--> The field Kantara.d is not visible
		System.out.println("-------------------------------------------");
		r1.test1();
//		r1.test2(); --> The method test2() from the type Kantara is not visible
//		r1.test3(); --> The method test3() from the type Kantara is not visible
//		r1.test4(); --> The method test4() from the type Kantara is not visible
		System.out.println("Shiddat End");
	}

}
