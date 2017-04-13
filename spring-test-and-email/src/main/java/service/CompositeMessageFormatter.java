
package service;

import java.util.List;

public class CompositeMessageFormatter implements MessageFormatter {

	private List<MessageFormatter> formatters;

	public CompositeMessageFormatter(List<MessageFormatter> formatters) {
		this.formatters = formatters;
	}

	@Override
	public String format(String message) {
		for (MessageFormatter formatter : this.formatters) {
			message = formatter.format(message);
		}

		return message;
	}

}