package constructor;

class ladu {
	String shape;
	double weight;
	String taste;

	ladu() {
		shape = "Gol";
		weight = 250.00;
		taste = "Yummuy";
	}

	void Khau() {
		System.out.println("Ladoo is " + shape + " vazan is :- " + weight + " Khayala ekdam " + taste);

	}
}

public class Ladoo {
	public static void main(String[] args) {
		ladu l1 = new ladu();
		l1.Khau();
	}

}
