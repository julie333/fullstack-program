package service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.Wiser;
import static org.assertj.core.api.Assertions.assertThat;

import config.TestMailConfig;
import config.TestRepositoryConfig;
import domain.Tweet;
import repository.TweetRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ServiceConfig.class, TestRepositoryConfig.class, TestMailConfig.class })
@ActiveProfiles("dev")
public class TweetServiceTests {

	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	TweetService tweetService;

	@Autowired
	Wiser wiser;

	@Test
	public void save() throws MessagingException, IOException {
		
		assertThat(wiser.getMessages()).hasSize(0);
		
//		Given
		Tweet t = new Tweet("author1", "text1");
		
//		When
		tweetService.save(t);
		
//		Then
		verify(tweetRepository).save(t);
		
		assertThat(wiser.getMessages()).hasSize(1);
		
		MimeMessage mimeMessage = wiser.getMessages().get(0).getMimeMessage();
		String from = mimeMessage.getFrom()[0].toString();
		String to = mimeMessage.getRecipients(RecipientType.TO)[0].toString();
		String subject = mimeMessage.getSubject();
		String body = mimeMessage.getContent().toString().trim();
		
		assertThat(from).isEqualTo("twitter@example.com");
		assertThat(to).isEqualTo("author1@example.com");
		assertThat(subject).isEqualTo("My Subject");
		assertThat(body).contains(String.format("Dear author1,%nNew Tweet has been posted : text1"));

		wiser.getMessages().clear();
	}

	@Test
	public void deleteById() {

		// When
		tweetService.deleteById(1);
		// Then
		verify(tweetRepository).deleteById(1);

	}

	@Test
	public void findById() {

		// Given
		Integer id = 1;
		Tweet tweet = new Tweet("me", "testing");

		// When
		when(tweetRepository.findById(id)).thenReturn(tweet);
		Tweet tweetFound = tweetService.findById(id);
		// Then
		assertThat(tweetFound).isEqualTo(tweet);
	}

	@Test
	public void findAll() {

		// When
		tweetService.findAll();
		// Then
		verify(tweetRepository).findAll();
	}

	@Test
	public void findAllByUsername() {

		// When
		tweetService.findAllByUsername("john");
		// Then
		verify(tweetRepository).findAllByUsername("john");
	}

	@Test
	public void findAllContainingHashTag() {
		
		String hashTag = "test";

		// When
		tweetService.findAllContainingHashTag(hashTag);
		// Then
		verify(tweetRepository).findAllContainingHashTag(hashTag);
	}

	@Test
	public void findAllMentioningUsername() {

		// When
		tweetService.findAllMentioningUsername("john");
		// Then
		verify(tweetRepository).findAllTweetsMentioningUsername("john");

	}

}
