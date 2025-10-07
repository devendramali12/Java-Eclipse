package automaticidgenertaor;

public class Employee {
	String name; // --> Non-Static Global Variable
	final String empid;
	double sal;
	private static int randomnum = 60;

	public Employee(String name, double sal) {

		this.name = name;
		this.empid = "2025WIPD" + randomnum++;
		this.sal = sal;
	}

	void details() {
		System.out.println("Employee name is " + name + " EmpId " + empid + " Salary Is:-  " + sal);
	}

}
