package com.rs.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.user.dao.UserDAO;
import com.rs.user.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public User saveUser(User newUser) {
		return userDAO.save(newUser);
	}

	@Override
	public void updateUser(User modifiedUser) {

	}

	@Override
	public void deleteUser(Long id) {

	}

	@Override
	public User getUser(Long id) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}
}
