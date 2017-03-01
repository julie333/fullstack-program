package repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import domain.Tweet;

@Repository
public class JdbcTweetRepository implements TweetRepository {
	
	
	private final JdbcTemplate jdbcTemplate;
	private final TweetMapper tweetMapper = new TweetMapper();
	

	@Autowired
	public JdbcTweetRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int count() {
		
		String sql = "select count(*) from Tweet";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void save(Tweet tweet) {
	
		String sql = "insert into Tweet(text,author) values (?,?)";
		jdbcTemplate.update(sql,tweet.getText(),tweet.getAuthor());
	}

	@Override
	public void deleteById(Integer id) {
		
		String sql = "delete from Tweet where id = ?";
		jdbcTemplate.update(sql, id);
	
	}

	@Override
	public Tweet findById(Integer id) {

		String sql = "select * from Tweet where id = ?";
		return jdbcTemplate.queryForObject(sql, tweetMapper, id);
	
	}

	@Override
	public List<Tweet> findAll() {

		String sql = "select * from Tweet";
		return jdbcTemplate.query(sql, tweetMapper);
	}

	@Override
	public List<Tweet> findAllByUsername(String username) {

		String sql = "select * from Tweet where upper(author) = upper(?)";
		return jdbcTemplate.query(sql, tweetMapper, username);
	}
	
	@Override
	public List<Tweet> findAllTweetsMentioningUsername(String username){
		
		String sql = "select * from Tweet where locate(concat('@',?),text)> 0 ";
		return jdbcTemplate.query(sql, tweetMapper, username);
		
	}

	@Override
	public List<Tweet> findAllContaining(String searchText) {

		String sql = "select * from Tweet where locate(?,text)> 0 ";
		return jdbcTemplate.query(sql, tweetMapper, searchText);
		
//		String sql = "select * from tweet where lower(text) like lower(?)";
//		return jdbcTemplate.query(sql, tweetMapper, "%" + searchText + "%");
	}
	
	@Override
	public List<Tweet> findAllContainingHashTag(String hashTag) {

		String sql = "select * from Tweet where locate(upper(concat('#',?)),upper(text)) > 0";
		return jdbcTemplate.query(sql, tweetMapper, hashTag);
	}
	

	@Override
	public List<String> findAllUsernames() {
		
		String sql = "select distinct lower(author) from tweet";
		return jdbcTemplate.queryForList(sql, String.class);
		
	}
	
	
	}
	



