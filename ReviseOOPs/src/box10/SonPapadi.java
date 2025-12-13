package box10;

class father {
	void land() {
		System.out.println("100 Acre Land");
	}
}

class devendra extends father {
	void chamdi() {
		System.out.println("Chamdigiri");
	}
}

public class SonPapadi {
	public static void main(String[] args) {
		father f1 = new devendra(); // Upcasting
		f1.land();
//		f1.chamdi();  SubClass Properties Are Hidden

		System.out.println("-------------------------------------------");

		devendra d1 = (devendra) f1; // Downcasting
		d1.chamdi();
		d1.land();

	}

}
