package com.rs.user.service;

import org.springframework.stereotype.Service;

import com.rs.user.model.UserInfo;

@Service
public class LoginServiceImpl implements LoginService {
	@Override
	public UserInfo authenticate(UserInfo login) {
		if ("admin".equals(login.getUsername()) && "admin".equals(login.getPassword())) {
			return login;
		}
		return null;
	}
}
