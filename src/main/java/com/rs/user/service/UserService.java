package com.rs.user.service;

import java.util.List;

import com.rs.user.model.User;

public interface UserService {
	User saveUser(User newUser);

	void updateUser(User modifiedUser);

	void deleteUser(Long id);

	User getUser(Long id);

	List<User> getAllUsers();
}
