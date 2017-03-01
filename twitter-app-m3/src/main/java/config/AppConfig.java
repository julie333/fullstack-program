package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import service.ServiceConfig;

@Configuration
@Import({ServiceConfig.class,RepositoryConfig.class,DataAccessConfig.class,MailConfig.class})
public class AppConfig {

}
