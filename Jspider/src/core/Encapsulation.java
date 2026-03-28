package core;

class Student {
	private int age;
	private int per;
	private String Name;

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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Student(int age, int per, String name) {

		this.age = age;
		this.per = per;
		Name = name;
	}

	void info() {
		System.out.println("Student Name is " + Name + " Age is " + age + " Percentage is " + per);
	}

}

public class Encapsulation {
	public static void main(String[] args) {

		Student s1 = new Student(10, 90, "Devendra");
		s1.info();

		System.out.println("----------------------------------------------------------------");
		s1.setAge(21);
		s1.setPer(85);
		s1.setName("Penga");

		s1.info();
	}

}
