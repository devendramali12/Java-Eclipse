package box2;

public class Matrix {
	public static void main(String[] args) {

		char gen = 'M';

		if (gen == 'M' || gen == 'm' || gen == 65) {
			System.out.println("Mard");
		} else if (gen == 'F' || gen == 'f' || gen == 90) {
			System.out.println("Streee");
		} else if (gen == '0' || gen == 'o') {
			System.out.println("Orry wale Log");
		} else {
			System.out.println("Invalid gender");
		}
	}

}
