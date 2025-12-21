package interfaces;

class devendra {

	private String s;
	private int age;

	public devendra(String s, int age) {
		this.s = s;
		this.age = age;

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

	void info() {
		System.out.println("Name Is " + s + " Age is " + age);
	}
}

public class E1 {
	public static void main(String[] args) {
		devendra d1 = new devendra("Devendra", 22);
		System.out.println(d1.getAge());
		System.out.println(d1.getS());

		System.out.println("------------------------------------------------");
		d1.setAge(25);
		d1.setS("Bala");

		System.out.println(d1.getAge());
		System.out.println(d1.getS());
	}

}
