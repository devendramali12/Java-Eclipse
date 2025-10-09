package box6;

public class TCS {
	public static void main(String[] args) {
		System.out.println("TCS Start");
		Employee e1 = new Employee(123, "Devendra", 25000);

		System.out.println("Revtriving Values Using Get Method");

		System.out.println(e1.getId());
		System.out.println(e1.getName());
		System.out.println(e1.getSal());

		System.out.println("-------------------------------------");

		System.out.println("After Using Setter Method");

		e1.setId(456);
		e1.setName("Bala");
		e1.setSal(36000);

		System.out.println(e1.getId());
		System.out.println(e1.getName());
		System.out.println(e1.getSal());

		System.out.println("-------------------------------------");

		Employee e2 = new Employee(96, "Ram", 20000);

		System.out.println("Revtriving Values Using Get Method");
		System.out.println(e2.getId());
		System.out.println(e2.getName());
		System.out.println(e2.getSal());

		System.out.println("--------------------------------------------");

		System.out.println("After Using Setter Method");
		e2.setId(69);
		e2.setName("Ravan");
		e2.setSal(5600);

		System.out.println(e2.getId());
		System.out.println(e2.getName());
		System.out.println(e2.getSal());

		System.out.println("TCS End");
	}

}
