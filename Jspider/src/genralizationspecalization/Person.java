package genralizationspecalization;

public class Person {

	String name;
	int age;
	char gen;

	public Person(String name, int age, char gen) {

		this.name = name;
		this.age = age;
		this.gen = gen;
	}

	void info() {
		System.out.println("Person name is " + name + " Age is " + age + " Gender is " + gen);
	}

}
