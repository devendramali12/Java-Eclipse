package interfaces;

// --> Task: Create an interface with one method and implement it
interface Animal {
	public abstract void sound();
}

class dog implements Animal {

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Dog Barks...");
	}

}

public class Test1 {
	public static void main(String[] args) {
		Animal a = new dog();
		a.sound();
	}

}
