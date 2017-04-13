package service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.MessageServiceConfig;


public class MessageServiceTests {

		@Test
	public void compositeFormatter() {

		@SuppressWarnings("resource")
		ApplicationContext context = //
				new AnnotationConfigApplicationContext(MessageServiceConfig.class);

		MessageService service = context.getBean(MessageService.class);

		assertThat(service.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
	}

}