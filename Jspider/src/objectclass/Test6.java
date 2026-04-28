package objectclass;

class modak {
	String fill;
	int size;

	public modak(String fill, int size) {
		this.fill = fill;
		this.size = size;

	}

	// Compare Filling
	@Override
	public boolean equals(Object obj) {
		modak m = (modak) obj;
		return this.fill == m.fill;
	}

	// Compare Size
//	@Override
//	public boolean equlas(object obj) {
//		modak m = (modak) obj;
//		return this.size == m.size;
//	}
}

public class Test6 {
	public static void main(String[] args) {
		modak m1 = new modak("coconut", 100);
		modak m2 = new modak("coconut", 100);

		System.out.println(m1.equals(m2));
	}

}
