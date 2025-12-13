package automatic_id_gen;

public class Wipro {
	public static void main(String[] args) {
		System.out.println("Wipro Start");

		Employee e1 = new Employee("Devndra", 20);
		Employee e2 = new Employee("kala", 420);
		Employee e3 = new Employee("LALA", 210);

		e1.details();
		e2.details();
		e3.details();
	}

}
