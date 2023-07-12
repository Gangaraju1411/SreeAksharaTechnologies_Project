package com.akshara.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshara.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {

	public UserDetails findByUsernameAndPassword(String username, String password);

	
}
