package specgen;

public class Student extends Person {

	int roll;
	double per;
	String college;

	public Student(String name, int age, char gen, int roll, double per, String college) {
		super(name, age, gen);
		this.roll = roll;
		this.per = per;
		this.college = college;

	}

	@Override
	void info() {
		System.out.println("Student Name Is " + name + " Age is " + age + " Gender is " + gen + " Roll No is " + roll
				+ " College name is " + college);
	}
}
