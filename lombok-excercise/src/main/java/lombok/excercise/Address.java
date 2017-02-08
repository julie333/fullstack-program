package lombok.excercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@AllArgsConstructor

public class Address {
	
	private String city;
	private String street;
	private int streetNum;
	private static final Logger logger = LogManager.getLogger(Address.class);
	

	public static void main(String[] args) {

		logger.warn("Hello, Logging!");
	}

}
