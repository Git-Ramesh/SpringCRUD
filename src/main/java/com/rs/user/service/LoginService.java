package com.rs.user.service;

import com.rs.user.model.UserInfo;

public interface LoginService {
	UserInfo authenticate(UserInfo login);
}
