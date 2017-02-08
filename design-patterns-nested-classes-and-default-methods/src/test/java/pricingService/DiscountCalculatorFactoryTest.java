package pricingService;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.DayOfWeek;

public class DiscountCalculatorFactoryTest {

	DiscountCalculatorFactory df = new DiscountCalculatorFactory();
	PricingService p = new PricingService();

	@Test
	public void testDiscountCalculatorFactory() {

		assertThat(df.getDiscountCalculatorFor(DayOfWeek.SATURDAY)).isInstanceOf(TenPercentDiscountCalculator.class);

		assertThat(df.getDiscountCalculatorFor(DayOfWeek.SUNDAY)).isInstanceOf(TenPercentDiscountCalculator.class);

		assertThat(df.getDiscountCalculatorFor(DayOfWeek.TUESDAY)).isInstanceOf(ZeroDiscountCalculator.class);

		assertThat(df.getDiscountCalculatorFor(DayOfWeek.SUNDAY)).isNotInstanceOf(ZeroDiscountCalculator.class);

	}

	@Test
	public void testPricingService() {

		p.setDayOfWeek(DayOfWeek.TUESDAY);
		assertThat(p.calculatePrice(4.0, 5.0)).isEqualTo(20.0);

		p.setDayOfWeek(DayOfWeek.WEDNESDAY);
		assertThat(p.calculatePrice(4.0, 5.0)).isEqualTo(20.0);

		p.setDayOfWeek(DayOfWeek.SATURDAY);
		assertThat(p.calculatePrice(4.0, 5.0)).isEqualTo(18.0);

		p.setDayOfWeek(DayOfWeek.SUNDAY);
		assertThat(p.calculatePrice(4.0, 5.0)).isEqualTo(18.0);

	}

}
