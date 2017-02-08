package pricingService;

public class TenPercentDiscountCalculator implements DiscountCalculator {

	@Override
	public double calculateDiscountedPrice(double price) {
		// TODO Auto-generated method stub
		return price * 0.9;
	}

}
