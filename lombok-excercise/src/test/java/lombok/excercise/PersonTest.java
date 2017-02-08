package lombok.excercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {
	
	Address adr = new Address("winti", "terra", 23);
	
	Person p = new Person("John", 28, adr);
	
	@Test
	public void testPerson(){
		
		assertEquals(28,p.getAge());
		assertEquals("terra",p.getAddress().getStreet());
		
		
	}
	
	


}
