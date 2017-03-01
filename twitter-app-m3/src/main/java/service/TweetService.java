package service;

import java.util.List;

import domain.Tweet;

public interface TweetService {
	
	void save(Tweet tweet);
	void deleteById(Integer id);
	Tweet findById(Integer id);
	List<Tweet> findAll();
	List<Tweet> findAllByUsername(String username);
	List<Tweet> findAllContainingHashTag(String hashTag);
	List<Tweet> findAllMentioningUsername(String username);

}
