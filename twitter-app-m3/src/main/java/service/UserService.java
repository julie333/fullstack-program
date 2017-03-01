package service;

import java.util.List;

import domain.User;

public interface UserService {
	
	public void registerNewUser(User user);
	public void deleteUser(Integer userId);
	public User findUser(Integer userId);
	public List<User> findAllUsers();

}

