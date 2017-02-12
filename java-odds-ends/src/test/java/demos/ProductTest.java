package demos;

import static org.junit.Assert.*;

import static demos.ProductColors.*;
import static demos.ProductSizes.*;

import org.junit.Test;

public class ProductTest {

	String userInputColor = "blue";
	String userInputSize = "xxl";
	String userInputSize1 = "s";

	ProductColors userColor = ProductColors.valueOf(userInputColor.toUpperCase());
	ProductSizes userSize = ProductSizes.valueOf(userInputSize.toUpperCase());
	ProductSizes userSize1 = ProductSizes.valueOf(userInputSize1.toUpperCase());

	Product p = new Product("bag", userColor, userSize, 20.0);
	Product p1 = new Product("bag", userColor, userSize1, 10.0);

	PriceCalculator cal = new PriceCalculator();

	@Test
	public void testProduct() {

		assertEquals(22.0, cal.calculatePrice(p), 0.0);
		assertEquals(10, cal.calculatePrice(p1), 0.0);
	}

}
