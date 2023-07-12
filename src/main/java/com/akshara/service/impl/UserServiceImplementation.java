package com.akshara.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshara.binding.LoginForm;
import com.akshara.binding.RegistrationForm;
import com.akshara.entity.UserDetails;
import com.akshara.repo.UserRepository;
import com.akshara.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private HttpSession session;

	@Override
	public String loginVerify(LoginForm form) {

		UserDetails entity = repo.findByUsernameAndPassword(form.getUsername(), form.getPassword());

		if (entity == null) {
			return "Invalid Credentials";
		}

		session.setAttribute("userId", entity.getUserId());

		return "success";
	}

	@Override
	public String userSignup(RegistrationForm registration) {
		
		UserDetails entity = new UserDetails();
		
		BeanUtils.copyProperties(registration, entity);
		
		repo.save(entity);
		
		return "User Details Saved";
	}

}
