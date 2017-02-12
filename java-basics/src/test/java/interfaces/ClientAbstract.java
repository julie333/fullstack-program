package interfaces;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientAbstract {

	@Test
	public void test() {
		
		ClassOneOne c = new ClassOneOne();
		ClassTwoTwo c2 = new ClassTwoTwo();
		
		assertEquals("HI, One!", c.generateMessage() ,"12");
		assertEquals("HI, Two!", c2.generateMessage() ,"23");

	}

}
