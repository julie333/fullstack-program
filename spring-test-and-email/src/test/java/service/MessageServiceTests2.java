package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertSame;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.Wiser;

import config.MessageServiceConfig;
import config.TestMailConfig;

@RunWith(SpringRunner.class)
// Before Wiser : @ContextConfiguration(classes = { MessageServiceConfig.class,
// MailConfig.class })
@ContextConfiguration(classes = { MessageServiceConfig.class, TestMailConfig.class })
@ActiveProfiles("dev")
public class MessageServiceTests2 {

	@Autowired
	MessageService service;

	@Autowired
	ApplicationContext context;

	@Autowired
	Wiser wiser;

	@Test
	public void compositeFormatterTest() throws Exception {
		assertSame(service, context.getBean(MessageService.class));
		assertThat(service.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
		assertThat(wiser.getMessages()).hasSize(1);
		
		MimeMessage mimeMessage;	
		mimeMessage = wiser.getMessages().get(0).getMimeMessage();
		String fromAddress = mimeMessage.getFrom()[0].toString();
		String toAddress = mimeMessage.getRecipients(MimeMessage.RecipientType.TO)[0].toString();
		String subject = mimeMessage.getSubject();
		String body = mimeMessage.getContent().toString().trim();
		wiser.getMessages().clear();
		
		assertThat(fromAddress).isEqualTo("someone@example.com");
		assertThat(toAddress).isEqualTo("someone@example.com");
		assertThat(subject).isEqualTo("My Subject");
		assertThat(body).isEqualTo("<strong>HELLO, WORLD</strong>");
	}
}