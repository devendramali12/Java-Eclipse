package core;

class GrandFather {
	void property() {
		System.out.println("Gold + Land");
	}

}

class Father extends GrandFather {
	void business() {
		System.out.println("Family Business");
	}

}

class Son extends Father {
	void job() {
		System.out.println("Software Engineer");
	}
}

public class MultiLevelInheritance {
	public static void main(String[] args) {

		Son s = new Son();
		s.property();
		s.business();
		s.job();

	}

}
