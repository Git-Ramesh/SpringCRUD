package com.rs.user.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1522912210021879360L;
	private String username;
	private String password;

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + "]";
	}
}
