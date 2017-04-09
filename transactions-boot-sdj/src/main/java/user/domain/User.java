package user.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@Entity //(name="users") -- this changes the name of the entity
@EqualsAndHashCode(exclude = "id")
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.PRIVATE)
	private Long id;
	
	@Column(name = "first_name",nullable=false,length=50)
	private String firstName;

	@Column(name = "last_name",nullable=false,length=50)
	private String lastName;

	@Column(nullable=false)
	private Integer age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> addresses = new ArrayList<>();

	public User() {
	}

	public User(Long id, String firstName, String lastName, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public User(String firstName, String lastName, Integer age) {
		this(null, firstName, lastName, age);
	}
	
	public void addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);
	}



}
