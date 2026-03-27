package practice;

class student {
	private int age;
	private int per;

	public student(int age, int per) {
		this.age = age;
		this.per = per;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPer() {
		return per;
	}

	public void setPer(int per) {
		this.per = per;
	}

	void info() {
		System.out.println("Student age is " + age + " Student Per is " + per);
	}
}

public class Encap {
	public static void main(String[] args) {
		student s1 = new student(25, 90);
		s1.info();

		s1.setAge(36);
		s1.setPer(52);
		s1.info();
	}

}
