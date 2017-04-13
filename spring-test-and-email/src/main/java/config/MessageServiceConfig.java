package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@ComponentScan("service")
@Configuration
@Profile("dev")
public class MessageServiceConfig {

	
	
//	@Bean
//	public MessageService messageService() {
//		
//		return new MessageService(messageFormatter());
//	}
//	
//	@Bean
//	public MessageFormatter messageFormatter() {
//		// @formatter:off
//		List<MessageFormatter> formatters = Arrays.asList(
//			new TrimmingMessageFormatter(),
//			new UpperCaseMessageFormatter(),
//			new HtmlMessageFormatter()
//		);
//		// @formatter:on
//
//		return new CompositeMessageFormatter(formatters);
//	}
//	


}
