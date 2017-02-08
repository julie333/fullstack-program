package messageFormatter;

public class HtmlMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		// TODO Auto-generated method stub

		StringBuilder htmlBuilder = new StringBuilder();
		htmlBuilder.append("<html><head><strong>");
		htmlBuilder.append(message);
		htmlBuilder.append("</strong></head></html>");

		return htmlBuilder.toString();

	}

}
