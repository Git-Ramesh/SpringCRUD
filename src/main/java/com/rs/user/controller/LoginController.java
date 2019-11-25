package com.rs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rs.user.model.UserInfo;
import com.rs.user.service.LoginService;

@Controller
@SessionAttributes("userInfo")
public class LoginController {
	@Autowired
	private LoginService loginService;

	 @ModelAttribute("userInfo")
	   public UserInfo setUpLoginForm() {
	      return new UserInfo();
	   }

	@RequestMapping("/login")
	public String userLogin(Model model) {
		System.out.println("login...");
//		Login login = new Login();
//		model.addAttribute("login", login);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userInfo") UserInfo userInfo, Model model) {
		System.out.println("doLogin...");
		UserInfo authentication = loginService.authenticate(userInfo);
		System.out.println(authentication);
		if (authentication == null) {
			return "redirect:login?error";
		}
		return "redirect:/user/register";
	}
}
