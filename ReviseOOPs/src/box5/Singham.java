package box5;

class simbha {

	static int i = 20; // --> Static Global Variable

	public static void fight() { // --> Static Method
		System.out.println("Gun Fight");
	}
}

public class Singham {
	static String s = "Kareena";

	public static void dance() {
		System.out.println("Fevicol Se....");
	}

	public static void main(String[] args) {

		System.out.println(simbha.i);
		simbha.fight();

		System.out.println("-----------------------------------------");

		System.out.println(Singham.s);
		Singham.dance();

		System.out.println("-------------------------------------------");

		System.out.println(Golmaal.s);
		Golmaal.ungalitod();
	}

}
