package accessspecifers;

public class Dharmendra {

	public int age = 22;
	private boolean isvirgin = true;
	double size = 5.2;
	protected String Relationship = "Single From Birth";

	void info() {
		System.out.println("Kya Hi Batatu Bhut Dukh Hai");
	}

	private void info1() {
		System.out.println("Kuch Bataunga Toh Khud Hi dedegi Paise.......");

	}

	protected void info2() {
		System.out.println("Usko Protect Kar Lunga ....");
	}

	public void info3() {
		System.out.println("Aja Kya Dekhna Hai Sabko Dikha Dunga .......");
	}

	public static void main(String[] args) {
		System.out.println("Dharmendra Start !!!");

		Dharmendra d1 = new Dharmendra();

		System.out.println(d1.age);
		System.out.println(d1.isvirgin);
		System.out.println(d1.Relationship);
		System.out.println(d1.size);

		System.out.println("--------------------------------------------");

		d1.info();
		d1.info1();
		d1.info2();
		d1.info3();

	}

}
