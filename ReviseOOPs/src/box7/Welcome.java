package box7;

public class Welcome {
	String color;
	int speed;

	// --> Non-Static Block 1
	{
		color = "red";
		speed = 360;
	}

	// --> Constructor
	Welcome() {
		color = "Grey";
		speed = 125;
	}

	public static void main(String[] args) {
		System.out.println("Main Start");

		Welcome w1 = new Welcome();
		System.out.println(w1.color);
		System.out.println(w1.speed);
		System.out.println("Main End");
	}

	// --> Non-Static Block 2
	{
		color = "Black";
		speed = 360;
	}

}
