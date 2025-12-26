package exceptions;

class devendra {
	private String s;
	private int age;

	public devendra(String s, int age) {
		this.s = s;
		this.age = age;
		System.out.println("Name is " + s + " Age is " + age);
		// TODO Auto-generated constructor stub
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class Encap {
	public static void main(String[] args) {
		devendra d1 = new devendra("devendra", 22);

		d1.setS("Devendra Mali");
		d1.setAge(23);

		System.out.println(d1.getS());
		System.out.println(d1.getAge());

		devendra d2 = new devendra("Mali", 96);

	}

}
