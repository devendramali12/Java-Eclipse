package box6;

public class Student { // ---> Step 1 Public Class

	// ---> Step 2 Private Attribute
	private String name; // ---> Private Non Static Global Variable
	private int rollno; // ---> -||-
	private double per;

	// Step 3 ---> Public Constructor
	public Student(String name, int rollno, double per) {
		this.name = name;
		this.rollno = rollno;
		this.per = per;

	}

	// --> Public getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public double getper() {
		return per;
	}

	public void setPer(double per) {

		this.per = per;
	}

	public int getRollno() {
		return rollno;
	}
}
