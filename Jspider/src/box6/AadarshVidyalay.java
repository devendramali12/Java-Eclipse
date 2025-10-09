package box6;

public class AadarshVidyalay {
	public static void main(String[] args) {

		System.out.println("School Start");

		Student s1 = new Student("Vijay", 25, 96);

		System.out.println(s1.getName());
		System.out.println(s1.getRollno());
		System.out.println(s1.getper());

		System.out.println("---------------------------------------------");

		Student s2 = new Student("Lala", 12, 45);

		System.out.println(s2.getName());
		System.out.println(s2.getRollno());
		System.out.println(s2.getper());

		s2.setName("Devnedra");
		System.out.println(s2.getName());

		System.out.println("School End");
	}

}
