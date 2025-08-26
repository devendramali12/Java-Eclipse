package box2;

public class Jadu {
	public static void main(String[] args) {
		
		int a = 40;
		int b = 45;
		int c = 60;
		
		int max = ((a>b)?((a>c)?a:c):((b>c)?b:c));
		System.out.println(max);
	}

}
