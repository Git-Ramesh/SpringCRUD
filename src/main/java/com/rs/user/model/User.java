package com.rs.user.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {
	private static final long serialVersionUID = 379058185469449939L;
	private Long id;
	private String name;
	private Integer age;
	private String email;
	private String address;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", address=" + address + "]";
	}
}
