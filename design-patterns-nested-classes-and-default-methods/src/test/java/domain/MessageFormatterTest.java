package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import messageFormatter.MessageFormatterFactory;

public class MessageFormatterTest {

	@Test
	public void testFactoryMethod() {

		assertThat(MessageFormatterFactory.createConsoleFormatter().format("Format Me")).isEqualTo("Format Me!!!");
		assertThat(MessageFormatterFactory.createHtmlFormatter().format("Format Me"))
				.isEqualTo("<html><head><strong>" + "Format Me</strong></head></html>");
		assertThat(MessageFormatterFactory.getDefaultmessageformatter().format("Format Me"))
				.isEqualTo("Default: Format Me");
		assertThat(MessageFormatterFactory.getAnonymousformatter().format("Format Me"))
				.isEqualTo("AnonymousFormatter: Format Me");

		assertThat(MessageFormatterFactory.createConsoleFormatter())
				.isNotSameAs(MessageFormatterFactory.createConsoleFormatter());
		assertThat(MessageFormatterFactory.createConsoleFormatter())
				.isNotSameAs(MessageFormatterFactory.createConsoleFormatter());
	}

	@Test
	public void testSingleton() {

		assertThat(MessageFormatterFactory.getConsolemessageformatter())
				.isSameAs(MessageFormatterFactory.getConsolemessageformatter());
		assertThat(MessageFormatterFactory.getHtmlmessageformatter())
				.isSameAs(MessageFormatterFactory.getHtmlmessageformatter());
		assertThat(MessageFormatterFactory.getDefaultmessageformatter())
				.isSameAs(MessageFormatterFactory.getDefaultmessageformatter());
		assertThat(MessageFormatterFactory.getAnonymousformatter())
				.isSameAs(MessageFormatterFactory.getAnonymousformatter());
	}

}
