package com.hrms.profile.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.hrms.profile.entity.User;

public interface UserService {
	
	ResponseEntity<?> addUser(User user) throws URISyntaxException;
	ResponseEntity<?> getAllUsers();
	ResponseEntity<User> getUserById(Integer id);
	ResponseEntity<?> deleteUser(Integer id);
	ResponseEntity<?> editUser(User user, Integer id) throws URISyntaxException;
	ResponseEntity<?> searchByName(String name, String nic);
	
	//For HATEOS enabled clients
	
	ResponseEntity<?> addUserResource(User user) throws URISyntaxException;
	Resources<Resource<User>>  getAllUserResources();
	Resource<User> getUserResourceById(Integer id);	
	ResponseEntity<?> editUserResource(User user, Integer id) throws URISyntaxException;

}
