package box8;

public class Student { // --> Step 1 Public Class

	// --> Step 2 Private Attributes

	private String name; // --> Private Non-Static Variable
	private int rollno;
	private double per;

	// Step 3 --> Public Constructor

	public Student(String name, int rollno, double per) {
		this.name = name;
		this.per = per;
		this.rollno = rollno;
	}

	// Step 4 --> Public Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getper() {
		return per;
	}

	public void setper(double per) {
		this.per = per;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

}
