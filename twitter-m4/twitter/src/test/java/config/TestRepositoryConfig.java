package config;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import repository.TweetRepository;
import repository.UserRepository;

@Configuration
@Profile("dev")
public class TestRepositoryConfig {
	
	@Bean
	public TweetRepository tweetRepository(){
		return mock(TweetRepository.class);
	}
	
	@Bean
	public UserRepository userRepository(){
		return mock(UserRepository.class);
	}


}
