package core;

class champak {
	champak() {
		System.out.println("Chamapklal");
	}
}

class jetha extends champak {
	jetha() {
		System.out.println("Jethalal");
	}

}

class tapu extends jetha {
	tapu() {
		System.out.println("Tapu");
	}
}

public class ImplicitConstructor {
	public static void main(String[] args) {
		tapu t1 = new tapu();
	}

}
