package service;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(2)
@Profile("dev")
public class UpperCaseMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return message.toUpperCase();
	}

}	