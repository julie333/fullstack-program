package domain;

import lombok.Data;

@Data

public class Tweet {
	
	private Integer id;
	private String author;
	private String text;
	

//	This constructor is created to use the RowMapper  
	public Tweet(Integer id, String author, String text) {
		super();
		this.id = id;
//		this(author, text);
		this.author = author;
		this.text = text;
	}
	
	public Tweet(String author, String text) {
		super();
		this.author = author;
		this.text = text;
	}
	
	
}
