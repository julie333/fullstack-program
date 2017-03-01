package repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import config.RepositoryConfig;
import config.TestDataAccessConfig;
import domain.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RepositoryConfig.class, TestDataAccessConfig.class })
@ActiveProfiles("dev")
@Transactional(readOnly = true)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
//	Do not need to do this when using @Transactional
//	@Before
//	public void emptyUserTable() {
//		userRepository.deleteAll();
//	}

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
