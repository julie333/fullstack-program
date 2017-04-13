package service;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Profile("dev")
public class TrimmingMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return message.trim();
	}

}