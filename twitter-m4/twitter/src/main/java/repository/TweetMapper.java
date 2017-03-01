package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import domain.Tweet;


public class TweetMapper implements RowMapper<Tweet> {

	@Override
	public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Tweet(
				rs.getInt("id"),
				rs.getString("author"),
				rs.getString("text")
				);
	}
	

}