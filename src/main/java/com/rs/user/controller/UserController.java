package com.rs.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.rs.user.model.UserInfo;
import com.rs.user.model.User;
import com.rs.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register")
	public String registerUser(@SessionAttribute("userInfo") UserInfo userInfo, @ModelAttribute("user") User user, Model model) {
		System.out.println("registerUser...");
		System.out.println(userInfo);
		if(user == null) {
			user = new User();
			System.out.println("I created new User");
			model.addAttribute("user", user);
		}
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegisterUser(@ModelAttribute("user") User newUser, Map<String, Object> model, BindingResult bindingResult) {
		System.out.println("doRegisterUser...");
		System.out.println(newUser);
		if (bindingResult.hasErrors()) {
			return "redirect:/user/register";
		}
		try {
			User user = userService.saveUser(newUser);
			model.put("user", user);
			return "redirect:/user/register?success";
		} catch(Exception e) {
			model.put("error", e.getLocalizedMessage());
			e.printStackTrace();
		}
		return "register";
	}
}
