package pricingService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;

import org.junit.Test;

public class PricingServicewithDateServiceTest {

	@Test
	public void mockDependancy() {

		DateService dateInterface = mock(DateService.class);
		PricingServicewithDateService p = new PricingServicewithDateService(dateInterface);

		when(dateInterface.getDayOfWeek()).thenReturn(DayOfWeek.SATURDAY);
		assertEquals(18.0, p.calculatePrice(4.0, 5.0), 0);

		when(dateInterface.getDayOfWeek()).thenReturn(DayOfWeek.MONDAY);
		assertEquals(20.0, p.calculatePrice(4.0, 5.0), 0);

	}

}
