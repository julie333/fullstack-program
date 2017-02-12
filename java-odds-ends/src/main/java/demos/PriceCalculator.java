package demos;

public class PriceCalculator {

	public double calculatePrice(Product p) {

		double price = p.getPrice() + p.getSize().getSurchargePercentage() * p.getPrice();

		System.out.format("Product %s Color %s Price %s \n", p.getName(), p.getColor(), price);
		return price;
	}
}
