package box4;

public class Array {
	public static void main(String[] args) {
//		int[] arr; // --> Array Declaration

//		arr = new int[6]; // --> Array Creation

		int[] gd = new int[6]; // --> Array Declaration and Creation

		System.out.println(gd[0]);
		System.out.println(gd[1]);
		System.out.println(gd[2]);
		System.out.println(gd[3]);
		System.out.println(gd[4]);
		System.out.println(gd[5]);

		System.out.println("----------------------------------------------");

		gd[0] = 10;
		gd[1] = 215;
		gd[2] = 415;
		gd[3] = 152;
		gd[4] = 875;
		gd[5] = 45;

		System.out.println(gd[0]);
		System.out.println(gd[1]);
		System.out.println(gd[2]);
		System.out.println(gd[3]);
		System.out.println(gd[4]);
		System.out.println(gd[5]);

	}

}
