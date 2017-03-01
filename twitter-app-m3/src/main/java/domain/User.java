package domain;

import lombok.Data;

@Data

public class User {
	
	private Integer id;
	private final String firstName;
	private final String lastName;
	private final String emailAddress;
	private final String username;
	private final String password;

	public User(Integer id, String firstName, String lastName, String emailAddress, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String emailAddress, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
	}
}
