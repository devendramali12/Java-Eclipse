package constructor;

class train {
	String route;
	int ticket;
	String door;

	// No Argument Constructor
	train() {
		route = "Ghatkopar To Andheri";
		ticket = 80;
		door = "Automatic";
	}

	void Khabar() {
		System.out.println(
				"This metro runs from " + route + " And its having fare of " + ticket + " With " + door + " Doors");
	}

}

public class Metro {
	public static void main(String[] args) {
		train t1 = new train();

		System.out.println(t1.door);
		System.out.println(t1.route);
		System.out.println(t1.ticket);

		t1.Khabar();

	}

}
