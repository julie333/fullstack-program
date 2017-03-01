package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.User;
import repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class DefaultUserService implements UserService {

	private final UserRepository repository;
	private static final Logger logger = LogManager.getLogger(DefaultUserService.class);

	@Autowired
	public DefaultUserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = false)
	public void registerNewUser(User user) {

		logger.trace("Registered new User");
		repository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(Integer userId) {

		repository.deleteById(userId);
		logger.trace("Deleted user with id " + userId);
	}

	@Override
	public User findUser(Integer userId) {

		logger.trace("Looking for user with userId" + userId);
		return repository.findById(userId);
	}

	@Override
	public List<User> findAllUsers() {

		logger.trace("List of users");
		return repository.findAll();
	}

}
