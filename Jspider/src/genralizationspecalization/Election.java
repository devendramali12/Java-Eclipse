package genralizationspecalization;

public class Election {
	public static void main(String[] args) {

		Person p1 = new Person("Chamapk", 65, 'M');

		Person p2 = new Person("Madhavi", 40, 'F');

		Student s1 = new Student("Vivek", 22, 'M', 59, 80.36, "SDFC");

		Employee e1 = new Employee("Devendra", 22, 'M', 80, 135000, "SDE");

		Goverment g1 = new Goverment();

		// Generalization
		g1.aadharcard(new Person("Chamapk", 65, 'M'));
		g1.aadharcard(p1);
		g1.aadharcard(p2);
		g1.aadharcard(s1);

		System.out.println("-----------------------------------------------------------------");

		// Specalization

		g1.scholarship(s1);
//		g1.scholarship(p1);  CTE
//		g1.taxPayement(p2);

		System.out.println("----------------------------------------------------------------");

		g1.taxPayement(e1);

	}

}
