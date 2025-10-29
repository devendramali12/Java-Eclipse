package genralizationspecalization;

public class Goverment {

	// generalized method // Person p = new Student
	// ("Vivek",22,'M',53,80.30,"SPDC");
	void aadharcard(Person p) {
		System.out.println(p.name + " Will Get Aadhar Card");
	}

	void scholarship(Student s) {

		if (s.per >= 70) {
			System.out.println(s.name + " Will Get a Schorship");
		} else {
			System.out.println(s.name + " Ladki pe kam Dyan De");
		}
	}

	void taxPayement(Employee e) {
		if (e.sal * 12 >= 1200000) {
			System.out.println(e.name + " Should Pay Tax");
			System.out.println("Tax payable 18% is : " + e.sal * 12 * 0.18 + " /rs Only");

		} else {
			System.out.println("Tax Dene Ki Zarurat Nahi.....");
		}
	}

}
