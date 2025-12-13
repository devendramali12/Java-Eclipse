package box9;

class Father {
	void land() {
		System.out.println("200 Land Acre");
	}
}

class son extends Father {

}

public class HumSaathSaathHai {
	public static void main(String[] args) {
		son s1 = new son();
		s1.land();
	}

}
