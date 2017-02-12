package generics;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	Person p = new Person();
	Pet pet = new Pet("Lily");

	@Test
	public void speaking() {

		p.pets.add(pet);
		assertEquals("helloIamyourpet", pet.speak());
	}

	@Test
	public void naming() {

		assertEquals("Lily", pet.getName());
	}
}
