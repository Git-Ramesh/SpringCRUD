package com.rs.user.dao;

import java.util.List;

import com.rs.user.model.User;

public interface UserDAO {
	User save(User user);

	void update(User user);

	void delete(Long id);

	User fetch(Long id);

	List<User> fetchAll();
}
