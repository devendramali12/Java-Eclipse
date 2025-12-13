package specgen;

public class Employee extends Person {
	int empid;
	double sal;
	String design;

	public Employee(String name, int age, char gen, int empid, double sal, String design) {
		super(name, age, gen);
		this.empid = empid;
		this.sal = sal;
		this.design = design;

	}

	@Override
	void info() {
		System.out.println("Employee Name is " + name + " Age Is " + age + " Gender is " + gen + " EMp Id " + empid
				+ " Salray is " + sal + " Designation is " + design);
	}

}
