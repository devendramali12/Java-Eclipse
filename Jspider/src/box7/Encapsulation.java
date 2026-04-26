package box7;

class Student {

	private int age;
	private String name;

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class Encapsulation {
	public static void main(String[] args) {
		Student s = new Student(22, "Devnedra");

		System.out.println(s.getAge());
		System.out.println(s.getName());

		System.out.println("-------------------------------------------");

		s.setAge(25);
		s.setName("Loser");

		System.out.println(s.getAge());
		System.out.println(s.getName());
	}

}
