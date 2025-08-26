package core_java;

public class Basnati {
	public static void main(String[] args) {
		int a = 20;
		int b = a++ + --a +a--;
		System.out.println(a);//19
		System.out.println(b);//60
	}

}
