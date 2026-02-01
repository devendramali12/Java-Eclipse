package interfaces;

interface vehicle {
	void start();

	void stop();
}

class Bike implements vehicle {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Bike Started");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Bike Stopped");
	}

}

public class Test2 {
	public static void main(String[] args) {
		vehicle v = new Bike();
		v.start();
		v.stop();
	}

}
