
package user.service;

import user.domain.User;

public interface UserService {

	void registerNewUser(User user);

	User findById(Long id);

	User findByFirstNameAndLastName(String firstName, String lastName);

	void deleteById(Long id);

}
