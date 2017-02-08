package pricingService;

import java.time.DayOfWeek;

public class DiscountCalculatorFactory {

	DiscountCalculator getDiscountCalculatorFor(DayOfWeek day) {
		if (day.toString().toUpperCase() == "SATURDAY" || day.toString().toUpperCase() == "SUNDAY")
			return new TenPercentDiscountCalculator();
		else
			return new ZeroDiscountCalculator();

	}
}
