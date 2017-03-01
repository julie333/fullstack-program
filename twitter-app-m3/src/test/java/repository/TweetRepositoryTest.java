package repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import config.RepositoryConfig;
import config.TestDataAccessConfig;
import domain.Tweet;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes ={RepositoryConfig.class, TestDataAccessConfig.class})
@ActiveProfiles("dev")
@Sql("/test-tweet-data.sql")

//No need to use the below scripts when using @Transactional bcos it rolls back each test method on its own
//@Sql(scripts = "/delete-test-data.sql",executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
// Also possible - @Sql(statements = "delete from Tweet")

@Transactional
public class TweetRepositoryTest {

	@Autowired
	TweetRepository tweetRepository;
	
	@Test
	public void save(){
		
		saveATweet();
		assertThat(tweetRepository.count()).isEqualTo(5);
		
	}
	
	@Test
	public void deleteById(){
		
		Tweet t = tweetRepository.findAll().get(0);
		tweetRepository.deleteById(t.getId());
		assertThat(tweetRepository.findAllUsernames()).containsExactlyInAnyOrder("author test2","author test3","author test4");
	}
	
	@Test
	public void findById(){
		
		Tweet t = tweetRepository.findAll().get(0);
		Tweet t2 = tweetRepository.findById(t.getId());
		assertThat(t2).isEqualTo(t);
			
	}
	
	@Test
	public void findAll(){
		
		assertThat(tweetRepository.findAll().size()).isEqualTo(4);
		List<String> authors = tweetRepository
				.findAll()
				.stream()
				.map(t -> t.getAuthor())
				.collect(toList());
		
		assertThat(authors).containsExactlyInAnyOrder("Author Test1","Author Test2","Author Test3","Author Test4");
	}
	
	@Test
	public void findAllByUsername(){
		
		Tweet t = new Tweet("Me","testing");
		tweetRepository.save(t);
		assertThat(tweetRepository.findAllByUsername("Me1")).isEmpty();
		assertThat(tweetRepository.findAllByUsername("Me").size()).isEqualTo(1);
	}
		
	@Test
	public void findAllContaining(){	
		
		Tweet t = new Tweet("Me","testing");
		tweetRepository.save(t);
		saveATweet();
		
		assertThat(tweetRepository.findAllContaining("est")).size().isEqualTo(6);
	}
	
	@Test
	public void findAllUsernames(){
		
	List<String> usernames = tweetRepository.findAllUsernames();
		
		assertThat(usernames.size()).isEqualTo(4);
		assertThat(usernames).containsExactlyInAnyOrder("author test1","author test2","author test3","author test4");
		
	}
	
	@Test
	public void findAllContainingHashTag(){
		
		saveATweet();
		assertThat(tweetRepository.findAllContainingHashTag("Test").size()).isEqualTo(1);
		saveAnotherTweet();
		assertThat(tweetRepository.findAllContainingHashTag("Test").size()).isEqualTo(2);
	}
	
	@Test
	public void findAllTweetsMentioningUsername(){
		
		saveAnotherTweet();
		assertThat(tweetRepository.findAllTweetsMentioningUsername("Test").size()).isEqualTo(1);

	}
	
	
	public void saveATweet(){
		
		Tweet t = new Tweet("Test", "Hello #Test");
		tweetRepository.save(t);
	}
	
	public void saveAnotherTweet(){
		
		Tweet t = new Tweet("Test2", "Hello #Test2 @Test");
		tweetRepository.save(t);
	}
	
	
	
	
}
