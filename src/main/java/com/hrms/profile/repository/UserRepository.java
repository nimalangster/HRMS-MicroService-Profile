package com.hrms.profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.profile.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	//@Query("SELECT user FROM User as user WHERE user.fullName=?1")
	public List<User> findByFullNameOrNic(String name, String nic);

}
