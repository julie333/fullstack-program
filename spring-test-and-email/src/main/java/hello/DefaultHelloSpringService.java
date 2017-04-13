package hello;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service("helloSpringService")

public class DefaultHelloSpringService implements HelloSpringService {

	private final JavaMailSender javaMailSender;

	private final String message;

	@Autowired
	public DefaultHelloSpringService(JavaMailSender javaMailSender, String message) {
		this.javaMailSender = javaMailSender;
		this.message = message;
	}

	@Override
	public String generateMessage() {
		sendNotificationMail(this.message);
		return this.message;
	}

	private void sendNotificationMail(String message) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setFrom("system@example.com");
			helper.setTo("test@example.com");
			helper.setSubject("Generated Message");
			helper.setText(message);
			javaMailSender.send(mimeMessage);
		}
		catch (MessagingException ex) {
			ex.printStackTrace(System.err);
		}
	}

}