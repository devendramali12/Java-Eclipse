package core_java;

public class Shizuka {
	public static void main(String[] args) {
		int a = 90;
		int b = a++;
		
		System.out.println("A Value is "+a);
		System.out.println("B Value is " +b);
		
		System.out.println("-----------------------------");
		
		int i = 50;
		int j = ++i;
		
		System.out.println("I Value is " + i);
		System.out.println("J Value is " + j);
		
		System.out.println("--------------------------------");
		
		int m = 30;
		int n = m--;
		
		System.out.println( "M Value is:-"+  m);
		System.out.println(   "N Value is ;-" +   n);
		
		System.out.println("----------------------------------");
		
		int p = 60;
		int q = --p;
		
		System.out.println("p value is "+p);
		System.out.println("Q Value is :-" +q);
	}

}
