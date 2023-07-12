package com.akshara.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshara.binding.LoginForm;
import com.akshara.binding.RegistrationForm;
import com.akshara.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private HttpSession session;


	@GetMapping("/")
	public String loginPage(Model model) {

		model.addAttribute("loginForm", new LoginForm());
		return "login";

	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {

		String status = service.loginVerify(form);

		if (status.contains("success")) {
			return "dashboard";
		}
		model.addAttribute( "errMsg",status);
		return "login";

	}

	@GetMapping("/loadregister")
	public String createAccount(Model model) {

		model.addAttribute("registerDetails", new RegistrationForm());

		return "register";

	}

	@PostMapping("/saveuser")
	public String createAccount(@ModelAttribute("registerDetails") RegistrationForm registrationDetails, Model model) {

		String signupResponse = service.userSignup(registrationDetails);
		model.addAttribute("msg", signupResponse);
		model.addAttribute("registerDetails", new RegistrationForm());

		return "register";

	}

	@GetMapping("/logout")
	public String logout() {

		session.invalidate();

		return "login";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
