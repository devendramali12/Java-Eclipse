package polymorphism;

class PriceCalculator {
	double calculatePrice(double basePrice) {
		return basePrice;
	}

	double calculatePrice(double basePrice, double discountPercent) {
		return basePrice - (basePrice * discountPercent / 100);
	}

	double calculatePrice(double basePrice, double discountPercent, double taxPercent) {
		double discountedPrice = basePrice - (basePrice * discountPercent / 100);
		return discountedPrice + (discountedPrice * taxPercent / 100);
	}
}

public class CompileTime1 {
	public static void main(String[] args) {
		PriceCalculator p1 = new PriceCalculator();

		System.out.println("Price:- " + p1.calculatePrice(1000));
		System.out.println("Price With Discount :- " + p1.calculatePrice(1000, 10));
		System.out.println("Final Price " + p1.calculatePrice(1000, 10, 18));
	}

}
