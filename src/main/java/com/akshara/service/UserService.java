package com.akshara.service;

import org.springframework.stereotype.Component;

import com.akshara.binding.LoginForm;
import com.akshara.binding.RegistrationForm;
@Component
public interface UserService {
	
	public String  loginVerify (LoginForm login);

	public String userSignup (RegistrationForm signup);


}
