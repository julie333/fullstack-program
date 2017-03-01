package service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.TestDataAccessConfig;
import config.TestRepositoryConfig;
import domain.User;
import repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DefaultUserService.class, TestDataAccessConfig.class, TestRepositoryConfig.class })
@ActiveProfiles("dev")
public class UserServiceTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Test
	public void registerNewUser() {

		User user = new User("john", "doe", "jdoe@j.com", "jdoe", "jdoe");

		// When
		userService.registerNewUser(user);
		// Then
		verify(userRepository).save(user);
	}

	@Test
	public void deleteUser() {

		// When
		userService.deleteUser(1);
		// Then
		verify(userRepository).deleteById(1);
	}

	@Test
	public void findUser() {

		// When
		userService.findUser(1);
		// Then
		verify(userRepository).findById(1);
	}

	@Test
	public void findAllUsers() {

		// When
		userService.findAllUsers();
		// Then
		verify(userRepository).findAll();
		
		User user1 = new User("john", "doe", "jdoe@j.com", "jdoe", "jdoe");
		User user2 = new User("jane", "doe", "jdoe@j.com", "jdoe", "jdoe");
		
		// When
		List<User> demoUsers = asList(user1,user2);
		when(userRepository.findAll()).thenReturn(demoUsers);

		// Then
		List<User> usernames = userService.findAllUsers();
		assertThat(usernames).isEqualTo(demoUsers);
	}

}
