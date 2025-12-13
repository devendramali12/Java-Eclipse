package specgen;

public class Election {
	public static void main(String[] args) {
		Person p1 = new Person("Champak", 65, 'M');
		p1.info();

		Student s1 = new Student("Vivek", 22, 'M', 59, 80.36, "SDFC");

		Employee e1 = new Employee("Devnedra", 22, 'M', 80, 135000, "SDE");

		// Generalization

		Goverment g1 = new Goverment();

		g1.aadharcard(p1);
		g1.aadharcard(e1);
		g1.aadharcard(s1);

		// Specalization
		g1.scholorship(s1);
		g1.taxPaymenet(e1);

	}

}
