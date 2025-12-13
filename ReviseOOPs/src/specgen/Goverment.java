package specgen;

public class Goverment {

	void aadharcard(Person p) {
		System.out.println(p.name + " Will Get AadharCard");

	}

	void scholorship(Student s) {

		if (s.per >= 70) {

			System.out.println(s.name + " Will Get a Scholorship");
		}

	}

	void taxPaymenet(Employee e) {
		if (e.sal * 12 >= 1200000) {
			System.out.println(e.name + " Should Pay Tax");

		}

	}

}
