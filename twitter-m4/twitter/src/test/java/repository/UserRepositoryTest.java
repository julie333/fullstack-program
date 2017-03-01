package repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={repository.JdbcUserRepository.class,twitter.TwitterApplication.class}, webEnvironment = WebEnvironment.NONE)
@Transactional
@Sql(statements = "delete from user")
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	@Transactional(readOnly = false)
	public void save() throws Exception {

		assertThat(userRepository.count()).isEqualTo(0);
		saveAUser();
		assertThat(userRepository.count()).isEqualTo(1);
	}

	@Test
	public void findAll() {

		save2User();
		assertThat(userRepository.count()).isEqualTo(2);
		List<String> users = userRepository
				.findAll()
				.stream()
				.map(u->u.getFirstName())
				.collect(toList());
		assertThat(users).containsExactlyInAnyOrder("jane","john");
		
	}

	@Test
	public void findById() {
		saveAUser();
		User user = userRepository.findByFirstNameAndLastName("john","doe");
		user = userRepository.findById(user.getId());
		assertThat(user.getFirstName()).isEqualTo("john");
	}

	@Test
	public void findByFirstNameAndLastName() {

		saveAUser();
		User user = userRepository.findByFirstNameAndLastName("john", "doe");
		assertThat(user.getFirstName()).isEqualTo("john");
		assertThat(user.getLastName()).isEqualTo("doe");
	}

	@Test
	@Transactional(readOnly = false)
	public void deleteAll() {

		save2User();
		assertThat(userRepository.count()).isEqualTo(2);
		userRepository.deleteAll();
		assertThat(userRepository.count()).isEqualTo(0);
	}

	@Test
	@Transactional(readOnly = false)
	public void deleteById() {

		saveAUser();
		User user = userRepository.findByFirstNameAndLastName("john", "doe");
		userRepository.deleteById(user.getId());
		assertThat(userRepository.count()).isEqualTo(0);
	}

	public void saveAUser() {

		User john = new User("john", "doe", "j.doe@gmail.com", "@jdoe", "jdooo");
		userRepository.save(john);

	}

	public void save2User() {

		User john = new User("john", "doe", "j.doe@gmail.com", "@jdoe", "jdooo");
		userRepository.save(john);

		User jane = new User("jane", "doe", "j.doe@gmail.com", "@janedoe", "jado");
		userRepository.save(jane);

	}

}
