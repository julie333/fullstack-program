package lombok.excercise;

import lombok.AllArgsConstructor;
import lombok.Data;
//import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@AllArgsConstructor

public class Person {

	private String name;
	private int age;
	private Address address;
	private static final Logger logger = LogManager.getLogger(Person.class);

	public String checkAge() {
		if (this.getAge() > 100 || this.getAge() < 0)
			throw new IllegalArgumentException("Invalid Age Entered");

		return "Valid Age";
	}

	public static void main(String[] args) {

		Address adr = new Address("Winti", "Terra", 23);
		Person person = new Person("Molly", 150, adr);

		logger.info("Hello, Logging!");

		try {
			if (person.checkAge().equalsIgnoreCase("Valid Age")) {
			}
		} catch (IllegalArgumentException ex) {
			logger.error("Invalid age", ex);

		}

	}

}
