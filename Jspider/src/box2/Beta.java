package box2;

public class Beta {
	public static void main(String[] args) {
		int m = 8;
		int n = 5;
		int p = m++ - --n + --m;
		int q = p++ - --n + m--;
		int r = (m+n+q+p);
		
		m++;
		n--;
		q+=100;
		r-=20;
		System.out.println(m+" "+n+" "+p+" "+ q+" "+r);
	}

}
