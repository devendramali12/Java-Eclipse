package box6;

public class StudentDriver {
	public static void main(String[] args) {
		// Creating Objects Calls No-Arg Constructor

		Student s1 = new Student();

//		System.out.println(new Student().name);
//		System.out.println(new Student().age);

		System.out.println(s1.name);
		System.out.println(s1.age);

		s1.display();
	}

}

/*
 * Because each time you write: new Student() a new object is created and the
 * constructor runs. You used new Student() three times:
 * 
 * Student s1 = new Student();
 * 
 * System.out.println(new Student().name);
 * 
 * System.out.println(new Student().age);
 * 
 * So constructor prints three times.
 */