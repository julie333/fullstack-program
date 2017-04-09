package user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.PRIVATE)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private AddressType type = AddressType.HOME;

	@Column(nullable = false, length = 100)
	private String street;

	@Column(nullable = false, length = 100)
	private String city;

	@Column(nullable = false, length = 100)
	private String country;

	@ManyToOne
	private User user;

	public Address() {
		/* default constructor: required by JPA */
	}

	public Address(AddressType type, String street, String city, String country, User user) {
		this();
		this.type = type;
		this.street = street;
		this.city = city;
		this.country = country;
		this.user = user;
	}

	public Address(AddressType type, String street, String city, String country) {
		this(type, street, city, country, null);
	}

	public Address(Long id, AddressType type, String street, String city,  String country,
			User user) {
		this(type, street, city,country, user);
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [id=" + this.id + ", type=" + this.type + ", street=" + this.street + ", city=" + this.city
				+ ", country=" + this.country + ", user="
				+ (this.user == null ? null : this.user.getId()) + "]";
	}

}