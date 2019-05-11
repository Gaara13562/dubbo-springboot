package study.service;

import java.util.List;

import study.pojo.User;

public interface IUserService {

	List<User> getAllUsers();

	void addUser(User user);

	User getUserById(Integer id);

	void updateUser(User user);

	void deleteUserById(Integer id);
}
