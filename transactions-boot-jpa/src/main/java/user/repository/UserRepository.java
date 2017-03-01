
package user.repository;

import java.util.List;

import user.domain.User;

public interface UserRepository {

	long count();

	void save(User user);

	List<User> findAll();

	User findById(Long id);

	User findByFirstNameAndLastName(String firstName, String lastName);

	void deleteAll();

	void deleteById(Long id);

}
