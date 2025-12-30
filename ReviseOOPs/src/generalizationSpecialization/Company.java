package generalizationSpecialization;

// --> Parent Class 

class employee {

	// --> Common behavior
	void work() {
		System.out.println("Employee is working");
	}
}

// --> Child class

class developer extends employee {

	// --> Developer-Specific Method
	void code() {
		System.out.println("Developer Writes Code");
	}
}

// --> Child Class
class tester extends employee {
	// --> Tester-Specific method
	void test() {
		System.out.println("Tester tests Application");
	}
}

// --> Main Class
public class Company {
	public static void main(String[] args) {

		developer d1 = new developer();
		d1.code(); // --> Specialized
		d1.work(); // --> Inherited

		System.out.println("-------------");
		tester t1 = new tester();
		t1.work();
		t1.test();
	}
}
