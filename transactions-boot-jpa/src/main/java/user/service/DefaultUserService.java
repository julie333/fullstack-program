
package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.domain.User;
import user.repository.UserRepository;


@Transactional(readOnly = true)
@Service
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public DefaultUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findById(id);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return this.userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Transactional(readOnly = false)
	@Override
	public void registerNewUser(User user) {
		this.userRepository.save(user);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteById(Long id) {
		this.userRepository.deleteById(id);
	}

}
