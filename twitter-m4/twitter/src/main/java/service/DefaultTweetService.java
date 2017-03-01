package service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Tweet;
import repository.TweetRepository;

@Service
@Transactional(readOnly = true)
public class DefaultTweetService implements TweetService {

	private final TweetRepository repository;
	private final JavaMailSender javaMailSender;
	private static final Logger logger = LogManager.getLogger(DefaultTweetService.class);

	@Autowired
	public DefaultTweetService(TweetRepository repository, JavaMailSender javaMailSender) {
		super();
		this.repository = repository;
		this.javaMailSender = javaMailSender;
	}

	private void sendNotificationEmailforTweet(Tweet t){
		
		String body = String.format("Dear %s,%nNew Tweet has been posted : %s", t.getAuthor(),t.getText());
		
		try{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setFrom("twitter@example.com");
		helper.setTo(t.getAuthor()+"@example.com");
		helper.setSubject("My Subject");
		helper.setText(body);
		javaMailSender.send(mimeMessage);
		}
		catch(MailSendException | MessagingException ex){
			logger.warn("Failed to send notification: "+ex.getMessage());
//			ex.printStackTrace(System.err);
		}	
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Tweet tweet) {

		repository.save(tweet);
		sendNotificationEmailforTweet(tweet);
		logger.trace(()->"New tweet Created" +tweet);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Integer id) {

		repository.deleteById(id);
		logger.trace(()->"Deleted tweet with id "+id);

	}

	@Override
	public Tweet findById(Integer id) {

		logger.trace(()->"Finding Tweet with id "+id);
		return repository.findById(id);
	}

	@Override
	public List<Tweet> findAll() {

		logger.trace("Finding List of tweets");
		return repository.findAll();
	}

	@Override
	public List<Tweet> findAllByUsername(String username) {
		logger.trace(()->"Tweet with username "+username);
		return repository.findAllByUsername(username);
	}

	@Override
	public List<Tweet> findAllContainingHashTag(String hashTag) {

		logger.trace("Tweet with hashTag "+hashTag);
		return repository.findAllContainingHashTag(hashTag);
	}

	@Override
	public List<Tweet> findAllMentioningUsername(String username) {

		logger.trace("Tweets mentioning username "+username);
		return repository.findAllTweetsMentioningUsername(username);
	}

}
