package core;

class Employee {
	void work() {
		System.out.println("Employee works");
	}
}

class Developer extends Employee {
	void code() {
		System.out.println("Developer Writes Code");
	}
}

public class UpcastingDemo {
	public static void main(String[] args) {

		// Up-casting (Child --> Parent)
		Employee e = new Developer();

		e.work();
//		e.code();  Not allowed
	}

}
