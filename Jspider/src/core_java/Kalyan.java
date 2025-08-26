package core_java;

public class Kalyan {
	public static void main(String[] args) {
		int m = 50;
		int n = (m+=20);
		int p = (m-=20)+(n*=2);
		int r = (m+n+p);
		System.out.println(r);
	}

}
