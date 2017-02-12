package interfaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyInterfaceTest {

	@Test
	public void classOne() {
		MyInterface myInterface = new ClassOne();

		assertEquals("Class One", myInterface.generateMessage());
	}

	@Test
	public void classTwo() {
		MyInterface myInterface = new ClassTwo();
		assertEquals("Class Two", myInterface.generateMessage());
	}

}
