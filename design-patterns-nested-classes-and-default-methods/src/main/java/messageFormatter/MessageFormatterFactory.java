package messageFormatter;

import lombok.Data;

@Data

public class MessageFormatterFactory {

	private static final MessageFormatter consoleMessageFormatter = new ConsoleMessageFormatter();
	private static final MessageFormatter htmlMessageFormatter = new HtmlMessageFormatter();
	private static final MessageFormatter defaultMessageFormatter = new DefaultMessageFormatter();

	// Methods - Returns different Instance always
	public static MessageFormatter createConsoleFormatter() {
		return new ConsoleMessageFormatter();
	}

	public static MessageFormatter createHtmlFormatter() {
		return new HtmlMessageFormatter();
	}

	// Methods - Returns same Instance always (Singleton)
	public static MessageFormatter getConsolemessageformatter() {
		return consoleMessageFormatter;
	}

	public static MessageFormatter getHtmlmessageformatter() {
		return htmlMessageFormatter;
	}

	public static MessageFormatter getDefaultmessageformatter() {
		return defaultMessageFormatter;
	}

	public static MessageFormatter getAnonymousformatter() {
		return anonymousFormatter;
	}

	// Inner Class
	private static class DefaultMessageFormatter implements MessageFormatter {

		@Override
		public String format(String message) {
			// TODO Auto-generated method stub
			return "Default: " + message;
		}
	}

	// Anonymous Inner Class
	private static final MessageFormatter anonymousFormatter = new MessageFormatter() {
		@Override
		public String format(String message) {
			// TODO Auto-generated method stub
			return "AnonymousFormatter: " + message;
		}
	};

}
