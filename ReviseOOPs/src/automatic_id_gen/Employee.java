package automatic_id_gen;

public class Employee {
	String name; // --> Non Static Global Variable
	final String empid;
	double sal;
	private static int randomnum = 600;

	// Constructor
	public Employee(String name, double sal) {
		this.name = name;
		this.empid = "2025WIPD" + randomnum++;
		this.sal = sal;

	}

	void details() {
		System.out.println("Employee name is :- " + name + " EMPID :- " + empid + " Salary is :- " + sal);
	}

}
