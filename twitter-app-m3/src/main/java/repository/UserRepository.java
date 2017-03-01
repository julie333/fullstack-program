package repository;

import java.util.List;
import domain.User;

public interface UserRepository {
	
	int count();
	void save(User user);
	List<User> findAll();
	User findById(Integer id);
	User findByFirstNameAndLastName(String firstName, String lastName); 
	void deleteAll(); 
	void deleteById(Integer id);
}



