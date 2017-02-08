package pricingService;

public class PricingServicewithDateService {

	private final DateService ds;

	public PricingServicewithDateService(DateService ds) {
		super();
		this.ds = ds;
	}

	public double calculatePrice(double quantity, double amount) {

		double basePrice = quantity * amount;
		DiscountCalculator dc = new DiscountCalculatorFactory().getDiscountCalculatorFor(ds.getDayOfWeek());
		return dc.calculateDiscountedPrice(basePrice);
	}
}
