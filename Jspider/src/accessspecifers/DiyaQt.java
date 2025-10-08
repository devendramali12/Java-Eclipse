package accessspecifers;

public class DiyaQt {
	public static void main(String[] args) {
		System.out.println("DiyaQt Start");

		Dharmendra d2 = new Dharmendra();
		System.out.println(d2.age);
		System.out.println(d2.Relationship);
		System.out.println(d2.size);
//		System.out.println(d2.isvirgin);  --> The field Dharmendra.isvirgin is not visible

		System.out.println("---------------------------------------");

		d2.info();
//		d2.info1(); --> The method info1() from the type Dharmendra is not visible
		d2.info2();
		d2.info3();
		System.out.println("DiyaQt End");
	}

}
