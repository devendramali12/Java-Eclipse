package box8;

// --> EncapSulation Example

public class AdarshVidyalay {
	public static void main(String[] args) {
		Student s1 = new Student("Vijay", 21, 36);

		System.out.println(s1.getName());
		System.out.println(s1.getper());
		System.out.println(s1.getRollno());

		System.out.println("-----------------------------------------------------------");

		s1.setName("Devendra");
		s1.setper(58);
		s1.setRollno(96);
		System.out.println(s1.getName());
		System.out.println(s1.getper());
		System.out.println(s1.getRollno());

	}

}
