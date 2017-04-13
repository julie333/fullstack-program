package service;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(3)
@Profile("dev")
public class HtmlMessageFormatter implements MessageFormatter {
	
	int a;

	@Override
	public String format(String message) {
		return "<strong>" + message + "</strong>";
	}

}