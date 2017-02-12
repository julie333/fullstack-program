package interfaces;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ClientTest {

	@Test
	public void mockDependancy() {
		
		MyInterface myInterface = mock(MyInterface.class);
		Client myClient = new Client(myInterface);
		
		when(myInterface.generateMessage()).thenReturn("HI, Mock!");

		assertEquals("HI, MOCK!", myClient.getClientClass());
	}
	
	@Test	public void stubDependancy() {
		MyInterface myInterface = new StubMyInterface();
		Client myClient = new Client(myInterface);

		assertEquals("HI, STUB!", myClient.getClientClass());
	}
}



	


	