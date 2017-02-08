package pricingService;

import java.time.DayOfWeek;

public class PricingService {

	private DayOfWeek dayOfWeek;

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public DayOfWeek getDayOfWeek() {
		// TODO Auto-generated method stub
		return this.dayOfWeek;
	}

	public double calculatePrice(double quantity, double amount) {

		double basePrice = quantity * amount;
		DiscountCalculator dc = new DiscountCalculatorFactory().getDiscountCalculatorFor(getDayOfWeek());
		return dc.calculateDiscountedPrice(basePrice);

	}

}
