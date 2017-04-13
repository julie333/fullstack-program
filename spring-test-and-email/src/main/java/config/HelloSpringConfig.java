
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("hello")
public class HelloSpringConfig {

	@Bean
	@Profile("dev")
	public String message() {
		return "Hello, Spring!";
	}
	
	public int smtpPort(){
		return 25;
	}
	
	public String smtpHost(){
		return "localhost";
	}
	
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(smtpHost());
		javaMailSender.setPort(smtpPort());
		return javaMailSender;
	}

}
