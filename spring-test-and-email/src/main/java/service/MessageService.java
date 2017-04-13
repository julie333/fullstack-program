package service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private  final MessageFormatter messageFormatter;
	private final JavaMailSender javaMailSender;
	
	public MessageService(List<MessageFormatter> messageFormatters,JavaMailSender javaMailSender) {
		this.messageFormatter = new CompositeMessageFormatter(messageFormatters);
		this.javaMailSender = javaMailSender;
	}

//	Combined both these constructors above:
//	dont have to give autowired to above as it is the only constructor available
//	
//	constructor introduced for added functionality
//	@Autowired
//	public MessageService(List<MessageFormatter> messageFormatters,JavaMailSender javaMailSender) {
//		this.messageFormatter = new CompositeMessageFormatter(messageFormatters);
//		this.javaMailSender = javaMailSender;
//	}
//	default constructor bcos both are final fields
//	public MessageService(MessageFormatter messageFormatter,JavaMailSender javaMailSender) {
//		this.messageFormatter = messageFormatter;
//		this.javaMailSender = javaMailSender;
//	}
	
	public String generateMessage() {
		this.sendNotificationEmail(messageFormatter.format("Hello, World"));
		return messageFormatter.format("Hello, World");
	}

	private void sendNotificationEmail(String message){
		
		try{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setFrom("someone@example.com");
		helper.setTo("someone@example.com");
		helper.setSubject("My Subject");
		helper.setText(message);
		javaMailSender.send(mimeMessage);
		}
		catch(MessagingException ex){
			ex.printStackTrace(System.err);
		}
		
	}
}

