
package service;


public class DefaultHelloSpringService implements HelloSpringService {

	@Override
	public String generateMessage() {
		return "Hello, Spring!";
	}

}
